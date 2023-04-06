package com.kodilla.tictactoe;

import java.util.Scanner;

public class Game {
    static Board board = new Board();

    public static void main(String[] args) {
        readPosition();
    }

//    private static void startGame() {}

    private static void readPosition() {
        Scanner scanner = new Scanner(System.in);
        board.writeBoard();

        int round=0;
        while (round < 9) {
            System.out.println("Podaj numer wiersza (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.println("Podaj numer kolumny (1-3)");
            int col = scanner.nextInt() - 1;


            if (board.setOnPosition(row, col, round)) {
                if (board.checkBoard()) {
                    break;
                } else {
                    round++;
                    board.writeBoard();
                }
            }
        }
    }
}
