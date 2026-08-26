import java.util.*;

public class triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        // Copy the last row
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Move from second-last row to top
        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                dp[j] = triangle.get(i).get(j)
                        + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = minimumTotal(triangle);

        System.out.println("Minimum path sum = " + result);
    }
}