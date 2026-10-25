public class prac224 {


        public static int closedIsland(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int count = 0;

            // Remove boundary-connected islands
            for (int i = 0; i < rows; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, cols - 1);
            }

            for (int j = 0; j < cols; j++) {
                dfs(grid, 0, j);
                dfs(grid, rows - 1, j);
            }

            // Count closed islands
            for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < cols - 1; j++) {
                    if (grid[i][j] == 0) {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }

            return count;
        }

        public static void dfs(int[][] grid, int i, int j) {
            int rows = grid.length;
            int cols = grid[0].length;

            if (i < 0 || j < 0 ||
                    i >= rows || j >= cols ||
                    grid[i][j] != 0) {
                return;
            }

            grid[i][j] = 1;

            // Explore four directions
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }

        public static void main(String[] args) {

            int[][] grid = {
                    {1,1,1,1,1,1,1,0},
                    {1,0,0,0,0,1,1,0},
                    {1,0,1,0,1,1,1,0},
                    {1,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,0}
            };

            System.out.println("Number of Closed Islands: "
                    + closedIsland(grid));
        }
    }



