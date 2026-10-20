
public class prac119 {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int answer = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int previousMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int end = start + k;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int descents = 0;

                for (int i = start; i < end; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);

                    int next = (i + 1 == end) ? start : i + 1;

                    if (nums[i] > nums[next]) {
                        descents++;
                    }
                }

                if (descents > 1 || previousMax > min) {
                    valid = false;
                    break;
                }

                previousMax = max;
            }

            if (valid) {
                answer += k;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        prac119 solution = new prac119();

        System.out.println(solution.sortableIntegers(new int[]{3, 1, 2}));
        System.out.println(solution.sortableIntegers(new int[]{7, 6, 5}));
        System.out.println(solution.sortableIntegers(new int[]{5, 8}));
        System.out.println(solution.sortableIntegers(new int[]{12, 18, 14}));
    }
}
