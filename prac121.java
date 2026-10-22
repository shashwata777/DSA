import java.util.Arrays;

public class prac121 {

    public static void main(String[] args) {
        Solu sol = new Solu();   // changed from Solution

        int[][] tests = {
                {0, 2, 1},      // expected 2
                {1, 0, 2},      // expected 2
                {2, 0, 1, 3},   // expected -1
                {0},            // expected 0
                {0, 1, 2, 3}    // expected 0
        };

        for (int[] t : tests) {
            System.out.println(Arrays.toString(t) + " -> " + sol.minOperations(t));
        }
    }
}

class Solu {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int p = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p = i;
                break;
            }
        }

        int best = Integer.MAX_VALUE;

        // cyclic ascending
        boolean asc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(p + i) % n] != i) {
                asc = false;
                break;
            }
        }
        if (asc) {
            best = Math.min(best, Math.min(p, n - p + 2));
        }

        // cyclic descending
        boolean desc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(p + i) % n] != (n - i) % n) {
                desc = false;
                break;
            }
        }
        if (desc) {
            best = Math.min(best, Math.min(n - p, (p + 1) % n + 1));
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}