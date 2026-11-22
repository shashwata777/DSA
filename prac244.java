public class prac244 {


    public class Main {
        public static boolean checkString(String s) {
            boolean foundB = false;

            for (char ch : s.toCharArray()) {
                if (ch == 'b') {
                    foundB = true;
                } else if (foundB) {
                    return false;
                }
            }

            return true;
        }

        public static void main(String[] args) {
            String s = "aaabbb";

            System.out.println(checkString(s));
        }
    }

}
