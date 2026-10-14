public class prac112 {

        public static String maxSumOfSquares(int num, int sum) {
            if (sum > 9 * num) {
                return "";
            }

            StringBuilder result = new StringBuilder();

            while (sum >= 9) {
                result.append('9');
                sum -= 9;
                num--;
            }

            if (num > 0 && sum > 0) {
                result.append((char) ('0' + sum));
                num--;
            }

            while (num > 0) {
                result.append('0');
                num--;
            }

            return result.toString();
        }

        public static void main(String[] args) {
            System.out.println(maxSumOfSquares(2, 3));  // 30
            System.out.println(maxSumOfSquares(2, 17)); // 98
            System.out.println(maxSumOfSquares(1, 10)); // empty string
        }
    }


