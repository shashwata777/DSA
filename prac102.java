import java.util.*;

public class prac102 {


        public static String largestNumber(int[] nums) {

            String[] arr = new String[nums.length];

            // Convert int to String
            for (int i = 0; i < nums.length; i++) {
                arr[i] = String.valueOf(nums[i]);
            }

            // Sort based on which combination is bigger
            Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

            // If all numbers are 0
            if (arr[0].equals("0")) {
                return "0";
            }

            // Join all strings
            StringBuilder result = new StringBuilder();

            for (String s : arr) {
                result.append(s);
            }

            return result.toString();
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();

            int[] nums = new int[n];

            System.out.println("Enter the elements:");

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            String answer = largestNumber(nums);

            System.out.println("Largest number: " + answer);
        }
    }

