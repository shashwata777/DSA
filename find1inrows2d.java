

import java.util.*;
public class find1inrows2d {




        public static int rowWithMax1s(int[][] mat, int n, int m) {

            int maxOnes = 0;
            int ans = -1;

            for (int i = 0; i < n; i++) {

                int count = 0;

                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 1) {
                        count++;
                    }
                }
                if (count > maxOnes) {
                    maxOnes = count;
                    ans = i;
                }
            }

            return ans;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);


            System.out.print("Enter number of rows: ");
            int n = sc.nextInt();

            System.out.print("Enter number of columns: ");
            int m = sc.nextInt();

            int[][] mat = new int[n][m];

            // Input matrix
            System.out.println("Enter the matrix:");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }



            int result = rowWithMax1s(mat, n, m);

            System.out.println("Row with maximum number of 1s: " + result);

            sc.close();
        }
    }

