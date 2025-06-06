package Sudoku;

import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;
    private Scanner scanner;

    public SudokuGame() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("=== Bem-vindo ao Sudoku! ===");
        board.loadPuzzle();

        while (!board.isComplete()) {
            board.display();
            System.out.print("Digite linha (0-8), coluna (0-8) e número (1-9): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int num = scanner.nextInt();

            if (!board.placeNumber(row, col, num)) {
                System.out.println("Movimento inválido. Tente novamente.");
            }
        }

        board.display();
        System.out.println("Parabéns! Você completou o Sudoku!");
        scanner.close();
    }

    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        game.play();
    }
}
