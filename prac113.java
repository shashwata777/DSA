import java.util.Arrays;

public class prac113 {








        public static int sumCounts(int[] nums) {
            int n = nums.length;
            int result = 0;

            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[101];
                int distinct = 0;

                for (int j = i; j < n; j++) {
                    if (!seen[nums[j]]) {
                        seen[nums[j]] = true;
                        distinct++;
                    }
                    result += distinct * distinct;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int[] test1 = {1, 2, 1};
            int[] test2 = {1, 1};

            System.out.println(Arrays.toString(test1) + " -> " + sumCounts(test1)); // 15
            System.out.println(Arrays.toString(test2) + " -> " + sumCounts(test2)); // 3
        }
    }

