public class prC120 {


        public static int minOperations(String s) {
            int n = s.length();

            boolean sorted = true;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) < s.charAt(i - 1)) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                return 0;
            }

            if (n == 2) {
                return -1;
            }

            char min = 'z';
            char max = 'a';

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                min = (char) Math.min(min, c);
                max = (char) Math.max(max, c);
            }

            if (s.charAt(0) == min || s.charAt(n - 1) == max) {
                return 1;
            }

            for (int i = 1; i < n - 1; i++) {
                if (s.charAt(i) == min || s.charAt(i) == max) {
                    return 2;
                }
            }

            return 3;
        }

        public static void main(String[] args) {
            System.out.println(minOperations("dog"));  // 1
            System.out.println(minOperations("card")); // 2
            System.out.println(minOperations("gf"));   // -1
            System.out.println(minOperations("omo"));  // 1
            System.out.println(minOperations("edc"));  // 3
            System.out.println(minOperations("abc"));  // 0
        }
    }


