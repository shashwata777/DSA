

import java.util.*;


public class prac228 {



        private int[][] graph;
        private int[] parent, depth, heavy, size, head, pos;
        private int[] tree;
        private char[] chars;
        private int currentPos;

        public List<Boolean> palindromePath(int n, int[][] edges,
                                            String s, String[] queries) {

            chars = s.toCharArray();

            int[] degree = new int[n];

            for (int[] e : edges) {
                degree[e[0]]++;
                degree[e[1]]++;
            }

            graph = new int[n][];

            for (int i = 0; i < n; i++) {
                graph[i] = new int[degree[i]];
            }

            Arrays.fill(degree, 0);

            for (int[] e : edges) {
                int u = e[0], v = e[1];
                graph[u][degree[u]++] = v;
                graph[v][degree[v]++] = u;
            }

            parent = new int[n];
            depth = new int[n];
            heavy = new int[n];
            size = new int[n];
            head = new int[n];
            pos = new int[n];

            Arrays.fill(parent, -1);
            Arrays.fill(heavy, -1);

            int[] order = new int[n];
            int count = 1;
            order[0] = 0;

            for (int i = 0; i < count; i++) {
                int u = order[i];

                for (int v : graph[u]) {
                    if (v == parent[u]) continue;

                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    order[count++] = v;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                int u = order[i];
                size[u] = 1;

                int maxSize = 0;

                for (int v : graph[u]) {
                    if (v == parent[u]) continue;

                    size[u] += size[v];

                    if (size[v] > maxSize) {
                        maxSize = size[v];
                        heavy[u] = v;
                    }
                }
            }

            currentPos = 0;

            for (int u = 0; u < n; u++) {
                if (parent[u] == -1 ||
                        heavy[parent[u]] != u) {

                    for (int v = u; v != -1; v = heavy[v]) {
                        head[v] = u;
                        pos[v] = currentPos++;
                    }
                }
            }

            int base = 1;
            while (base < n) base <<= 1;

            tree = new int[base * 2];

            for (int i = 0; i < n; i++) {
                tree[base + pos[i]] = 1 << (chars[i] - 'a');
            }

            for (int i = base - 1; i > 0; i--) {
                tree[i] = tree[i * 2] ^ tree[i * 2 + 1];
            }

            List<Boolean> result = new ArrayList<>();

            for (String q : queries) {
                String[] parts = q.split(" ");

                if (parts[0].equals("update")) {
                    int u = Integer.parseInt(parts[1]);
                    char c = parts[2].charAt(0);

                    chars[u] = c;

                    int p = base + pos[u];
                    tree[p] = 1 << (c - 'a');

                    for (p >>= 1; p > 0; p >>= 1) {
                        tree[p] = tree[p * 2] ^ tree[p * 2 + 1];
                    }

                } else {
                    int u = Integer.parseInt(parts[1]);
                    int v = Integer.parseInt(parts[2]);

                    int mask = 0;

                    while (head[u] != head[v]) {
                        if (depth[head[u]] < depth[head[v]]) {
                            int temp = u;
                            u = v;
                            v = temp;
                        }

                        mask ^= rangeQuery(
                                base, pos[head[u]], pos[u]
                        );

                        u = parent[head[u]];
                    }

                    if (depth[u] > depth[v]) {
                        int temp = u;
                        u = v;
                        v = temp;
                    }

                    mask ^= rangeQuery(base, pos[u], pos[v]);

                    result.add((mask & (mask - 1)) == 0);
                }
            }

            return result;
        }

        private int rangeQuery(int base, int left, int right) {
            int mask = 0;

            left += base;
            right += base;

            while (left <= right) {
                if ((left & 1) == 1) {
                    mask ^= tree[left++];
                }

                if ((right & 1) == 0) {
                    mask ^= tree[right--];
                }

                left >>= 1;
                right >>= 1;
            }

            return mask;
        }

        public static void main(String[] args) {

            prac228 solution = new prac228();

            // Example 1
            int n1 = 3;
            int[][] edges1 = {{0, 1}, {1, 2}};
            String s1 = "aac";

            String[] queries1 = {
                    "query 0 2",
                    "update 1 b",
                    "query 0 2"
            };

            System.out.println("Example 1:");
            System.out.println(
                    solution.palindromePath(n1, edges1, s1, queries1)
            );

            // Example 2
            int n2 = 4;
            int[][] edges2 = {
                    {0, 1}, {0, 2}, {0, 3}
            };

            String s2 = "abca";

            String[] queries2 = {
                    "query 1 2",
                    "update 0 b",
                    "query 2 3",
                    "update 3 a",
                    "query 1 3"
            };

            System.out.println("Example 2:");
            System.out.println(
                    solution.palindromePath(n2, edges2, s2, queries2)
            );
        }
    }


