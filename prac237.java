
import java.util.*;

public class prac237 {



    public class Main {

        public static int[] assignTasks(int[] servers, int[] tasks) {

            int n = servers.length;
            int m = tasks.length;

            int[] ans = new int[m];

            // Free servers: [weight, index]
            PriorityQueue<int[]> free = new PriorityQueue<>(
                    (a, b) -> {
                        if (a[0] != b[0]) {
                            return Integer.compare(a[0], b[0]);
                        }
                        return Integer.compare(a[1], b[1]);
                    }
            );

            // Busy servers: [availableTime, weight, index]
            PriorityQueue<long[]> busy = new PriorityQueue<>(
                    (a, b) -> {
                        if (a[0] != b[0]) {
                            return Long.compare(a[0], b[0]);
                        }
                        if (a[1] != b[1]) {
                            return Long.compare(a[1], b[1]);
                        }
                        return Long.compare(a[2], b[2]);
                    }
            );

            for (int i = 0; i < n; i++) {
                free.offer(new int[]{servers[i], i});
            }

            long time = 0;

            for (int i = 0; i < m; i++) {

                time = Math.max(time, i);

                // Release completed servers
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();

                    free.offer(new int[]{
                            (int) s[1],
                            (int) s[2]
                    });
                }

                // Wait if all servers are busy
                if (free.isEmpty()) {

                    time = busy.peek()[0];

                    while (!busy.isEmpty() && busy.peek()[0] <= time) {
                        long[] s = busy.poll();

                        free.offer(new int[]{
                                (int) s[1],
                                (int) s[2]
                        });
                    }
                }

                int[] server = free.poll();

                int weight = server[0];
                int index = server[1];

                ans[i] = index;

                busy.offer(new long[]{
                        time + tasks[i],
                        weight,
                        index
                });
            }

            return ans;
        }

        public static void main(String[] args) {

            int[] servers = {3, 3, 2};
            int[] tasks = {1, 2, 3, 2, 1, 2};

            int[] result = assignTasks(servers, tasks);

            System.out.println(Arrays.toString(result));
        }
    }

}
