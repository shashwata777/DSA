public class prac233 {


    public class Main {

        public static int minMoves(int[] nums) {
            int max = nums[0];
            int moves = 0;

            // Find maximum element
            for (int num : nums) {
                max = Math.max(max, num);
            }

            // Calculate total moves
            for (int num : nums) {
                moves += max - num;
            }

            return moves;
        }

        public static void main(String[] args) {
            int[] nums = {2, 1, 3};

            System.out.println(minMoves(nums));
        }
    }

}
