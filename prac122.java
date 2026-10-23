import java.util.Arrays;

public class prac122 {




    public class Main {

        public static int sortPermutation(int[] nums) {
            boolean sorted = true;
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    sorted = false;
                    ans &= nums[i];
                }
            }

            return sorted ? 0 : ans;
        }

        public static void main(String[] args) {
            int[] nums1 = {0, 3, 2, 1};
            int[] nums2 = {0, 1, 3, 2};
            int[] nums3 = {3, 2, 1, 0};

            System.out.println(sortPermutation(nums1)); // 1
            System.out.println(sortPermutation(nums2)); // 2
            System.out.println(sortPermutation(nums3)); // 0
        }
    }

}
