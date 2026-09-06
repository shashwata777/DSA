import java.util.*;

public class word {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // Word completely matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length) {
            return false;
        }

        // Character does not match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Search in 4 directions
        boolean found =
                dfs(board, word, row + 1, col, index + 1) ||
                        dfs(board, word, row - 1, col, index + 1) ||
                        dfs(board, word, row, col + 1, index + 1) ||
                        dfs(board, word, row, col - 1, index + 1);

        // Restore cell
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {

        word obj = new word();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        boolean result = obj.exist(board, word);

        System.out.println(result);
    }
}