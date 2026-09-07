import java.util.*;

public class nearest {

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        nearest obj = new nearest();

        int[] nums = {1, 2, 3, 1};

        int result = obj.findPeakElement(nums);

        System.out.println("Peak index: " + result);
        System.out.println("Peak element: " + nums[result]);
    }
}