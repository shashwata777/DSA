import java.util.*;

public class subset {

        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);

            backtrack(nums, 0, new ArrayList<>(), result);

            return result;
        }

        private static void backtrack(int[] nums, int start,
                                      List<Integer> current,
                                      List<List<Integer>> result) {

            result.add(new ArrayList<>(current));

            for (int i = start; i < nums.length; i++) {

                // Skip duplicate elements at the same level
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }

                current.add(nums[i]);

                backtrack(nums, i + 1, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }

        public static void main(String[] args) {

            int[] nums = {1, 2, 2};

            List<List<Integer>> result = subsetsWithDup(nums);

            System.out.println(result);
        }
    }

