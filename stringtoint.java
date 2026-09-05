import java.util.*;

public class stringtoint {

        public static int myAtoi(String s) {

            int i = 0;
            int n = s.length();

            // 1. Ignore leading spaces
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            // 2. Check sign
            int sign = 1;

            if (i < n && s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (i < n && s.charAt(i) == '+') {
                i++;
            }

            // 3. Convert digits
            int result = 0;

            while (i < n && Character.isDigit(s.charAt(i))) {

                int digit = s.charAt(i) - '0';

                // 4. Check overflow
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return sign == 1
                            ? Integer.MAX_VALUE
                            : Integer.MIN_VALUE;
                }

                result = result * 10 + digit;
                i++;
            }

            return result * sign;
        }

        public static void main(String[] args) {

            System.out.println(myAtoi("42"));
            System.out.println(myAtoi(" -042"));
            System.out.println(myAtoi("1337c0d3"));
            System.out.println(myAtoi("0-1"));
            System.out.println(myAtoi("words and 987"));
            System.out.println(myAtoi("91283472332"));
            System.out.println(myAtoi("-91283472332"));
        }
    }

