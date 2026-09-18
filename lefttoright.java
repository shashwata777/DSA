
import java.util.*;
public class lefttoright {

        public static int takeCharacters(String s, int k) {

            int n = s.length();

            if (k == 0) {
                return 0;
            }

            int[] total = new int[3];

            // Count total number of a, b and c
            for (char ch : s.toCharArray()) {
                total[ch - 'a']++;
            }

            // If any character is less than k, answer is impossible
            if (total[0] < k || total[1] < k || total[2] < k) {
                return -1;
            }

            // Maximum number of each character we can leave behind
            int[] limit = new int[3];

            for (int i = 0; i < 3; i++) {
                limit[i] = total[i] - k;
            }

            int[] window = new int[3];

            int left = 0;
            int maxWindow = 0;

            // Sliding window
            for (int right = 0; right < n; right++) {

                int current = s.charAt(right) - 'a';
                window[current]++;

                // Shrink window if we leave too many characters
                while (window[0] > limit[0] ||
                        window[1] > limit[1] ||
                        window[2] > limit[2]) {

                    int leftChar = s.charAt(left) - 'a';
                    window[leftChar]--;
                    left++;
                }

                maxWindow = Math.max(maxWindow, right - left + 1);
            }

            // Characters taken = total length - characters left
            return n - maxWindow;
        }

        public static void main(String[] args) {

            String s = "aabaaaacaabc";
            int k = 2;

            int answer = takeCharacters(s, k);

            System.out.println("Minimum minutes: " + answer);
        }


    }


