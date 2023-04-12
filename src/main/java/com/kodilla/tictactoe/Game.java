package com.kodilla.tictactoe;

import java.security.InvalidParameterException;
import java.util.*;

public class Game {
    private Board board;
    private char currentPlayer;
    public Game() {
        board = new Board();
        currentPlayer = 'X';
    }




    void startGame() {

        board.printBoard();

        while (!board.isBoardFull()) {

            int[] position;
            try {
                position = readPositionFromUser();
            } catch (InvalidPositionParametersException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                board.setOnPosition(position[0], position[1], currentPlayer);
                if (board.checkBoard()) {
                    System.out.println("WYGRAL " + currentPlayer + "!");
                    break;
                } else {
                    switchPlayer();
                    board.printBoard();
                }
            } catch (FieldAlreadyTakenException e) {
                System.out.println("\n * " + e.getMessage() + " Ponow probe! *");
            }


            if (board.isBoardFull()) {
                System.out.println("REMIS!");
            }
        }

    }

    void startGameWithAI() {
        board.printBoard();

        while (!board.isBoardFull()) {

            int[] position;
            try {
                position = readPositionFromUser();
            } catch (InvalidPositionParametersException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                board.setOnPosition(position[0], position[1], currentPlayer);

            } catch (FieldAlreadyTakenException e) {
                System.out.println("\n * " + e.getMessage() + " Ponow probe! *");
            }

            if (board.checkBoard()) {
                System.out.println("WYGRAL " + currentPlayer + "!");
                break;
            } else {
                switchPlayer();
                moveAI(currentPlayer);
                if (board.checkBoard()) {
                    System.out.println("WYGRAL " + currentPlayer + "!");
                    break;
                }
                switchPlayer();
            }


            if (board.isBoardFull()) {
                System.out.println("REMIS!");
            }
        }
    }

    private void moveAI(char symbol) {

        Random random = new Random();

        List<int[]> freeSlots = board.getEmptyPositions();
        int randIndex = random.nextInt(freeSlots.size());
        int[] position = freeSlots.get(randIndex);
        try {
            board.setOnPosition(position[0], position[1], symbol);
        } catch (FieldAlreadyTakenException ignored) {
        }

    }



    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    private int[] readPositionFromUser() throws InvalidPositionParametersException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gracz " +currentPlayer +". Podaj litere kolumny i numer wiersza (np. A1): ");
        String position = scanner.nextLine();
        int col = position.charAt(0);
        int row = position.charAt(1);

        if(col >= 'A' && col <= 'C') {
            col -= 'A';
        } else if (col >= 'a' && col <= 'c') {
            col -= 'a';
        } else {
            throw new InvalidPositionParametersException("Niepoprawna kolumna\n");
        }

        if (row >= '1' && row <= '3') {
            row -= '1';
        } else {
            throw new InvalidPositionParametersException("Niepoprawny wiersz\n");
        }

        return new int[]{col, row};
    }


}
