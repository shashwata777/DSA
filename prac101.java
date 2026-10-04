public class prac101 {


        static class Solution {
            public int maximumGap(String skill, String station) {
                int n = skill.length(), m = station.length();
                if (n == 1) return 0;

                int[] pre = new int[n];
                int[] suf = new int[n];

                // earliest finishing positions (left to right)
                int j = 0;
                for (int i = 0; i < n; i++) {
                    while (station.charAt(j) != skill.charAt(i)) j++;
                    pre[i] = j++;
                }

                // latest starting positions (right to left)
                j = m - 1;
                for (int i = n - 1; i >= 0; i--) {
                    while (station.charAt(j) != skill.charAt(i)) j--;
                    suf[i] = j--;
                }

                int ans = 0;
                for (int i = 1; i < n; i++) {
                    ans = Math.max(ans, suf[i] - pre[i - 1]);
                }
                return ans;
            }
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.maximumGap("aa", "aaaa"));      // expected 3
            System.out.println(sol.maximumGap("xyz", "xyzz"));     // expected 2
            System.out.println(sol.maximumGap("cbc", "cbcdbc"));   // expected 4
            System.out.println(sol.maximumGap("a", "abc"));        // expected 0
        }
    }

