

import java.util.*;

public class prac239 {

        public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {

            TreeSet<Integer> available = new TreeSet<>();

            PriorityQueue<int[]> busy = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a[0], b[0])
            );

            int[] count = new int[k];

            for (int i = 0; i < k; i++) {
                available.add(i);
            }

            for (int i = 0; i < arrival.length; i++) {

                while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                    int[] completed = busy.poll();
                    available.add(completed[1]);
                }

                if (available.isEmpty()) {
                    continue;
                }

                int start = i % k;

                Integer server = available.ceiling(start);

                if (server == null) {
                    server = available.first();
                }

                available.remove(server);

                count[server]++;

                busy.offer(new int[]{
                        arrival[i] + load[i], server
                });
            }

            int max = 0;

            for (int c : count) {
                max = Math.max(max, c);
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                if (count[i] == max) {
                    result.add(i);
                }
            }

            return result;
        }

        public static void main(String[] args) {

            int k = 3;

            int[] arrival = {1, 2, 3, 4, 5};
            int[] load = {5, 2, 3, 3, 3};

            List<Integer> ans = busiestServers(k, arrival, load);

            System.out.println(ans);
        }
    }


