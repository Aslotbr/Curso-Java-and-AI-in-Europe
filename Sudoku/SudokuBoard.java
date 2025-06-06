package Sudoku;

public class SudokuBoard {
    private int[][] board;
    private boolean[][] fixed;

    public SudokuBoard() {
        board = new int[9][9];
        fixed = new boolean[9][9];
    }

    public void loadPuzzle() {
        int[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = puzzle[i][j];
                if (puzzle[i][j] != 0) {
                    fixed[i][j] = true;
                }
            }
        }
    }

    public void display() {
        System.out.println("   0 1 2   3 4 5   6 7 8");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("  +-------+-------+-------+");
            System.out.print(i + " | ");
            for (int j = 0; j < 9; j++) {
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println("  +-------+-------+-------+");
    }

    public boolean placeNumber(int row, int col, int num) {
        if (row < 0 || row >= 9 || col < 0 || col >= 9 || num < 1 || num > 9) return false;
        if (fixed[row][col]) return false;
        if (!isValidMove(row, col, num)) return false;

        board[row][col] = num;
        return true;
    }

    public boolean isValidMove(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean isComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }
}
