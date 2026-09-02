import java.util.*;

public class simplelypath {

        public static String simplifyPath(String path) {

            Deque<String> stack = new ArrayDeque<>();

            String[] parts = path.split("/");

            for (String part : parts) {

                // Ignore empty parts and "."
                if (part.isEmpty() || part.equals(".")) {
                    continue;
                }

                // Go to parent directory
                if (part.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.removeLast();
                    }
                }

                // Normal directory/file name
                else {
                    stack.addLast(part);
                }
            }

            // If stack is empty, path is root
            if (stack.isEmpty()) {
                return "/";
            }

            StringBuilder result = new StringBuilder();

            for (String directory : stack) {
                result.append("/").append(directory);
            }

            return result.toString();
        }

        public static void main(String[] args) {

            String path = "/home/user/Documents/../Pictures";

            String result = simplifyPath(path);

            System.out.println("Input:  " + path);
            System.out.println("Output: " + result);
        }
    }

