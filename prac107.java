import java.util.Scanner;

public class prac107 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Excel column title: ");
            String columnTitle = sc.next().toUpperCase();

            int result = 0;

            for (int i = 0; i < columnTitle.length(); i++) {
                int value = columnTitle.charAt(i) - 'A' + 1;
                result = result * 26 + value;
            }

            System.out.println("Column Number: " + result);

            sc.close();
        }
    }


