import java.util.*;

public class validcombination {


        static List<List<Integer>> result = new ArrayList<>();

        public static List<List<Integer>> combinationSum3(int k, int n) {
            result.clear();

            backtrack(1, k, n, new ArrayList<>());

            return result;
        }

        static void backtrack(int start, int k, int target, List<Integer> current) {

            if (current.size() == k) {
                if (target == 0) {
                    result.add(new ArrayList<>(current));
                }
                return;
            }

            for (int i = start; i <= 9; i++) {

                if (i > target) {
                    break;
                }

                current.add(i);

                backtrack(i + 1, k, target - i, current);

                current.remove(current.size() - 1);
            }
        }

        public static void main(String[] args) {

            int k = 3;
            int n = 9;

            System.out.println(combinationSum3(k, n));
        }
    }

