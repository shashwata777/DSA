



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

    public class prac116 {

        public static int minSwaps(int[] nums) {
            int n = nums.length;
            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                arr[i][0] = nums[i];
                arr[i][1] = digitSum(nums[i]);
            }

            // Sort by digit sum, then by number.
            Arrays.sort(arr, (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            // Map each number to its correct sorted position.
            Map<Integer, Integer> targetIndex = new HashMap<>();

            for (int i = 0; i < n; i++) {
                targetIndex.put(arr[i][0], i);
            }

            // Map each original index to its destination.
            int[] destination = new int[n];

            for (int i = 0; i < n; i++) {
                destination[i] = targetIndex.get(nums[i]);
            }

            boolean[] visited = new boolean[n];
            int swaps = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i] || destination[i] == i) {
                    continue;
                }

                int j = i;
                int cycleLength = 0;

                while (!visited[j]) {
                    visited[j] = true;
                    j = destination[j];
                    cycleLength++;
                }

                swaps += cycleLength - 1;
            }

            return swaps;
        }

        private static int digitSum(int num) {
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            return sum;
        }

        public static void main(String[] args) {
            int[] nums = {18, 43, 34, 16};

            System.out.println(minSwaps(nums));
        }
    }


