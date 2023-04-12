package com.kodilla.tictactoe;

import java.util.*;

public class Game {
    UserMenu userMenu;
    private Board board;
    private char currentPlayer;
    public Game() {
        userMenu = new UserMenu();
        if (userMenu.isBasicBoard()) {
            board = new BasicBoard();
        } else {
            board = new ExtendedBoard();
        }

        currentPlayer = 'X';
    }




//    void startGame() {
//
//        board.printBoard();
//
//        while (!board.isBoardFull()) {
//
//            int[] position;
//            try {
//                position = readPositionFromUser();
//            } catch (InvalidPositionParametersException e) {
//                System.out.println(e.getMessage());
//                continue;
//            }
//
//            try {
//                board.setOnPosition(position[0], position[1], currentPlayer);
//                if (board.checkBoard()) {
//                    System.out.println("WYGRAL " + currentPlayer + "!");
//                    break;
//                } else {
//                    switchPlayer();
//                    board.printBoard();
//                }
//            } catch (FieldAlreadyTakenException e) {
//                System.out.println("\n * " + e.getMessage() + " Ponow probe! *");
//            }
//
//
//            if (board.isBoardFull()) {
//                System.out.println("REMIS!");
//            }
//        }
//
//    }

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
            } catch (FieldAlreadyTakenException e) {
                System.out.println("\n * " + e.getMessage() + " Ponow probe! *");
                continue;
            }

            if (board.checkBoard()) {
                System.out.println("WYGRAL " + currentPlayer + "!");
                break;
            } else {
                switchPlayer();
                if(userMenu.isVersusComputer()) {
                    computerMove(currentPlayer);
                    if (board.checkBoard()) {
                        System.out.println("WYGRAL " + currentPlayer + "!");
                        break;
                    }
                    switchPlayer();
                }
            }

            if (board.isBoardFull()) {
                System.out.println("REMIS!");
            }
        }
    }

    private void computerMove(char symbol) {

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
        System.out.println(position.length());

        // sprawdzenie poprawności długości pozycji
        int expectedLength = (userMenu.isBasicBoard())? 2 : 3;
        System.out.println(expectedLength);
        if (position.length() < 2 || position.length() > expectedLength) {
            throw new InvalidPositionParametersException("Niepoprawna dana - dlugosc.");
        }
        // sprawdzenie poprawności znaków pozycji
        if (!position.matches("^[A-Za-z0-9]+$")) {
            throw new InvalidPositionParametersException("Niepoprawna dana.");
        }


        int col = position.toUpperCase().charAt(0);
        int row = Integer.parseInt(position.substring(1));

        char maxColUppercase = (userMenu.isBasicBoard())? 'C': 'J';
        int maxRow = (userMenu.isBasicBoard())? 3 : 10;


        if (col >= 'A' && col <= maxColUppercase) {
            col -= 'A';
        } else {
            throw new InvalidPositionParametersException("Niepoprawna kolumna\n");
        }

        if (row >= 1 && row <= maxRow) {
            row -= 1;
        } else {
            throw new InvalidPositionParametersException("Niepoprawny wiersz\n");
        }

        return new int[]{col, row};
    }


}
