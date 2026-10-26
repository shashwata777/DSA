import java.util.*;

public class prac225 {





    public class Main {

        public static int countIslands(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;

            boolean[][] visited = new boolean[m][n];

            int count = 0;

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i][j] > 0 && !visited[i][j]) {

                        long sum = 0;

                        Stack<int[]> stack = new Stack<>();
                        stack.push(new int[]{i, j});
                        visited[i][j] = true;

                        while (!stack.isEmpty()) {

                            int[] cell = stack.pop();
                            int r = cell[0];
                            int c = cell[1];

                            sum += grid[r][c];

                            for (int d = 0; d < 4; d++) {

                                int nr = r + dr[d];
                                int nc = c + dc[d];

                                if (nr >= 0 && nr < m &&
                                        nc >= 0 && nc < n &&
                                        grid[nr][nc] > 0 &&
                                        !visited[nr][nc]) {

                                    visited[nr][nc] = true;
                                    stack.push(new int[]{nr, nc});
                                }
                            }
                        }

                        if (sum % k == 0) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }

        public static void main(String[] args) {

            int[][] grid1 = {
                    {0, 2, 1, 0, 0},
                    {0, 5, 0, 0, 5},
                    {0, 0, 1, 0, 0},
                    {0, 1, 4, 7, 0},
                    {0, 2, 0, 0, 8}
            };

            int k1 = 5;

            System.out.println("Output 1: " +
                    countIslands(grid1, k1));

            int[][] grid2 = {
                    {3, 0, 3, 0},
                    {0, 3, 0, 3},
                    {3, 0, 3, 0}
            };

            int k2 = 3;

            System.out.println("Output 2: " +
                    countIslands(grid2, k2));
        }
    }

}
