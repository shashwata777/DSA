public class prac230 {



        static final int MOD = 1_000_000_007;

        public static int uniquePaths(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            long[][] fromLeft = new long[m][n];
            long[][] fromAbove = new long[m][n];

            fromLeft[0][0] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    long right = fromLeft[i][j];
                    long down = fromAbove[i][j];

                    if (i == m - 1 && j == n - 1) {
                        return (int) ((right + down) % MOD);
                    }

                    if (grid[i][j] == 0) {

                        long total = (right + down) % MOD;

                        // Move right
                        if (j + 1 < n) {
                            fromLeft[i][j + 1] =
                                    (fromLeft[i][j + 1] + total) % MOD;
                        }

                        // Move down
                        if (i + 1 < m) {
                            fromAbove[i + 1][j] =
                                    (fromAbove[i + 1][j] + total) % MOD;
                        }

                    } else {

                        // Mirror redirects right to down
                        if (i + 1 < m) {
                            fromAbove[i + 1][j] =
                                    (fromAbove[i + 1][j] + right) % MOD;
                        }

                        // Mirror redirects down to right
                        if (j + 1 < n) {
                            fromLeft[i][j + 1] =
                                    (fromLeft[i][j + 1] + down) % MOD;
                        }
                    }
                }
            }

            return 0;
        }

        public static void main(String[] args) {

            int[][] grid = {
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 0, 0}
            };

            System.out.println(uniquePaths(grid));
        }
    }

