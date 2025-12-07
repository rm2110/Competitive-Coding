import java.util.Scanner;

public class sudoku_validation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();

        boolean valid = isValidSudoku(board, n);
        System.out.println(valid ? "YES" : "NO");
    }

    public static boolean isValidSudoku(int[][] board, int n) {
        int blockSize = (int)Math.sqrt(n);
        if (blockSize * blockSize != n) {
            return false;
        }

        // Check rows
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int val = board[i][j];
                if (val < 1 || val > n) return false;
                if (seen[val]) return false;
                seen[val] = true;
            }
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                int val = board[i][j];
                if (val < 1 || val > n) return false;
                if (seen[val]) return false;
                seen[val] = true;
            }
        }

        // Check sub-boxes
        for (int blockRow = 0; blockRow < n; blockRow += blockSize) {
            for (int blockCol = 0; blockCol < n; blockCol += blockSize) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < blockSize; i++) {
                    for (int j = 0; j < blockSize; j++) {
                        int val = board[blockRow + i][blockCol + j];
                        if (val < 1 || val > n) return false;
                        if (seen[val]) return false;
                        seen[val] = true;
                    }
                }
            }
        }

        // All checks passed
        return true;
    }
}
