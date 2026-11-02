

import java.util.Arrays;

public class prac232 {



    public class Main {

        public static int minMoves2(int[] nums) {
            Arrays.sort(nums);

            int median = nums[nums.length / 2];
            int moves = 0;

            for (int num : nums) {
                moves += Math.abs(num - median);
            }

            return moves;
        }

        public static void main(String[] args) {

            int[] nums = {1, 10, 2, 9};

            int result = minMoves2(nums);

            System.out.println(result);
        }
    }

}
