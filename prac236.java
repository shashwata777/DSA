


import java.util.*;

public class prac236 {



    public class Main {

        public static int[] countServers(int n, int[][] logs, int x, int[] queries) {

            Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

            int m = queries.length;

            int[][] sortedQueries = new int[m][2];

            for (int i = 0; i < m; i++) {
                sortedQueries[i][0] = queries[i];
                sortedQueries[i][1] = i;
            }

            Arrays.sort(sortedQueries, (a, b) ->
                    Integer.compare(a[0], b[0]));

            int[] ans = new int[m];

            Map<Integer, Integer> map = new HashMap<>();

            int left = 0;
            int right = 0;

            for (int[] query : sortedQueries) {

                int q = query[0];
                int index = query[1];

                int start = q - x;

                // Add logs inside the right boundary
                while (right < logs.length && logs[right][1] <= q) {
                    int server = logs[right][0];

                    map.put(server, map.getOrDefault(server, 0) + 1);
                    right++;
                }

                // Remove logs outside the left boundary
                while (left < right && logs[left][1] < start) {
                    int server = logs[left][0];

                    map.put(server, map.get(server) - 1);

                    if (map.get(server) == 0) {
                        map.remove(server);
                    }

                    left++;
                }

                ans[index] = n - map.size();
            }

            return ans;
        }

        public static void main(String[] args) {

            int n = 3;

            int[][] logs = {
                    {1, 3},
                    {2, 6},
                    {1, 5}
            };

            int x = 5;

            int[] queries = {10, 11};

            int[] result = countServers(n, logs, x, queries);

            System.out.println(Arrays.toString(result));
        }
    }

}
