import java.util.*;

public class calculate {


        public static int calculate(String s) {

            int n = s.length();
            int num = 0;
            char sign = '+';

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {

                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }

                if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {

                    if (sign == '+') {
                        stack.push(num);
                    }
                    else if (sign == '-') {
                        stack.push(-num);
                    }
                    else if (sign == '*') {
                        stack.push(stack.pop() * num);
                    }
                    else if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }

                    sign = c;
                    num = 0;
                }
            }

            int result = 0;

            for (int x : stack) {
                result += x;
            }

            return result;
        }

        public static void main(String[] args) {

            String s = "3+2*2";

            int result = calculate(s);

            System.out.println("Input: " + s);
            System.out.println("Output: " + result);
        }
    }

