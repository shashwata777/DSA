
import java.util.Arrays;

public class prac226 {



        public static String[] createGrid(int m, int n) {
            String[] grid = new String[m];

            for (int i = 0; i < m; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == n - 1) {
                        sb.append('.');
                    } else {
                        sb.append('#');
                    }
                }

                grid[i] = sb.toString();
            }

            return grid;
        }

        public static void main(String[] args) {
            int m = 3;
            int n = 3;

            String[] result = createGrid(m, n);

            System.out.println(Arrays.toString(result));

            for (String row : result) {
                System.out.println(row);
            }
        }
    }


