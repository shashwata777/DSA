

import java.util.Arrays;
public class prac243 {


    public class Main {

        public static int minimumChanges(String s, int k) {

            int n = s.length();
            int[][] cost = new int[n][n];

            // Step 1: Precompute semi-palindrome costs
            for (int len = 2; len <= n; len++) {

                for (int i = 0; i + len <= n; i++) {

                    int j = i + len - 1;
                    cost[i][j] = Integer.MAX_VALUE;

                    for (int d = 1; d < len; d++) {

                        if (len % d != 0) {
                            continue;
                        }

                        int changes = 0;

                        for (int r = 0; r < d; r++) {

                            int left = i + r;
                            int right = i + len - d + r;

                            while (left < right) {

                                if (s.charAt(left) != s.charAt(right)) {
                                    changes++;
                                }

                                left += d;
                                right -= d;
                            }
                        }

                        cost[i][j] = Math.min(cost[i][j], changes);
                    }
                }
            }

            // Step 2: Dynamic Programming
            int INF = 1000000000;

            int[][] dp = new int[k + 1][n + 1];

            for (int[] row : dp) {
                Arrays.fill(row, INF);
            }

            dp[0][0] = 0;

            for (int p = 1; p <= k; p++) {

                for (int i = 2 * p; i <= n; i++) {

                    for (int j = 2 * (p - 1); j <= i - 2; j++) {

                        if (dp[p - 1][j] == INF) {
                            continue;
                        }

                        dp[p][i] = Math.min(
                                dp[p][i],
                                dp[p - 1][j] + cost[j][i - 1]
                        );
                    }
                }
            }

            return dp[k][n];
        }

        public static void main(String[] args) {

            String s1 = "abcac";
            int k1 = 2;
            System.out.println(minimumChanges(s1, k1));

            String s2 = "abcdef";
            int k2 = 2;
            System.out.println(minimumChanges(s2, k2));

            String s3 = "aabbaa";
            int k3 = 3;
            System.out.println(minimumChanges(s3, k3));
        }
    }

}
