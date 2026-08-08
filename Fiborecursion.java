import java.util.Scanner;

public class Fiborecursion {

    // Recursive function
    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Please enter a non-negative number.");
        } else {
            System.out.println("The " + n + "th Fibonacci number is: "
                    + fibonacci(n));
        }

        sc.close();
    }
}