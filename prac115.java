
import java.util.Arrays;

public class prac115 {

    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] square;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            update(1, 0, n - 1, last[x] + 1, i);

            last[x] = i;
            ans = (ans + square[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int left, int right,
                        int ql, int qr) {

        if (ql > right || qr < left) {
            return;
        }

        if (ql <= left && right <= qr) {
            add(node, left, right, 1);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        square[node] = (square[node * 2]
                + square[node * 2 + 1]) % MOD;
    }

    private void add(int node, int left, int right, long d) {
        long len = right - left + 1L;
        long oldSum = sum[node];

        square[node] = (square[node]
                + 2L * d % MOD * oldSum % MOD
                + len * d % MOD * d) % MOD;

        sum[node] = (oldSum + len * d) % MOD;
        lazy[node] = (lazy[node] + d) % MOD;
    }

    private void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        add(node * 2, left, mid, lazy[node]);
        add(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    public static void main(String[] args) {
        prac115 solution = new prac115();

        int[] nums1 = {1, 2, 1};
        System.out.println(solution.sumCounts(nums1));

        int[] nums2 = {2, 2};
        System.out.println(solution.sumCounts(nums2));
    }
}
