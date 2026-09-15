
import java.util.*;
public class overlappal {


        public static int maxPalindromes(String s, int k) {
            int n = s.length();

            boolean[][] dp = new boolean[n][n];

            // Check all palindromic substrings
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {

                    if (s.charAt(i) == s.charAt(j) &&
                            (j - i <= 1 || dp[i + 1][j - 1])) {

                        dp[i][j] = true;
                    }
                }
            }

            // dp2[i] = maximum palindromes using first i characters
            int[] dp2 = new int[n + 1];

            for (int i = 1; i <= n; i++) {

                // Do not select a palindrome ending at i-1
                dp2[i] = dp2[i - 1];

                for (int j = 0; j < i; j++) {

                    // Check length >= k and palindrome
                    if (i - j >= k && dp[j][i - 1]) {
                        dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                    }
                }
            }

            return dp2[n];
        }

        public static void main(String[] args) {

            String s1 = "abaccdbbd";
            int k1 = 3;

            System.out.println(maxPalindromes(s1, k1));

            String s2 = "adbcda";
            int k2 = 2;

            System.out.println(maxPalindromes(s2, k2));
        }
    }



