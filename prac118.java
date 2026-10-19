import java.util.*;

public class prac118 {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        prac118 obj = new prac118();

        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;

        System.out.println(obj.targetIndices(nums, target));
    }
}