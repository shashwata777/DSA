

import java.util.*;

public class prac229 {


        static class State {
            int node, count;
            long dist;

            State(int node, int count, long dist) {
                this.node = node;
                this.count = count;
                this.dist = dist;
            }
        }

        public static int shortestPath(int n, int[][] edges,
                                       String labels, int k) {

            List<int[]>[] graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] e : edges) {
                graph[e[0]].add(new int[]{e[1], e[2]});
            }

            long[][] dist = new long[n][k + 1];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Long.MAX_VALUE);
            }

            PriorityQueue<State> pq = new PriorityQueue<>(
                    (a, b) -> Long.compare(a.dist, b.dist)
            );

            dist[0][1] = 0;
            pq.offer(new State(0, 1, 0));

            while (!pq.isEmpty()) {

                State cur = pq.poll();

                int u = cur.node;
                int count = cur.count;
                long d = cur.dist;

                if (d != dist[u][count]) {
                    continue;
                }

                if (u == n - 1) {
                    return (int) d;
                }

                for (int[] edge : graph[u]) {

                    int v = edge[0];
                    int w = edge[1];

                    int newCount;

                    if (labels.charAt(u) == labels.charAt(v)) {
                        newCount = count + 1;
                    } else {
                        newCount = 1;
                    }

                    if (newCount > k) {
                        continue;
                    }

                    long newDist = d + w;

                    if (newDist < dist[v][newCount]) {
                        dist[v][newCount] = newDist;
                        pq.offer(new State(v, newCount, newDist));
                    }
                }
            }

            return -1;
        }

        public static void main(String[] args) {

            int n = 3;

            int[][] edges = {
                    {0, 1, 1},
                    {1, 2, 1},
                    {0, 2, 3}
            };

            String labels = "aab";
            int k = 1;

            int result = shortestPath(n, edges, labels, k);

            System.out.println(result);
        }
    }

