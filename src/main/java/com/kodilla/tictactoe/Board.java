package com.kodilla.tictactoe;

public class Board {

    char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    public Board() {

    }

    public void writeBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public boolean setOnPosition(int row, int col, int round) {

        char symbol;
        if (round % 2 == 0) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }

        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        } else {
            System.out.println("*** To miejsce jest juz zajete. *** \n");
            return false;
        }


    }


    public boolean checkBoard() {
        boolean check = false;
        char symbol = ' ';
        for (int i = 0; i < 3; i++) {

            // Check rows
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]  && board[i][0]!= ' ') {
                check = true;
                symbol = board[i][0];
            }

            // Check columns
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i]!= ' ') {
                check = true;
                symbol = board[0][i];
            }
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1]!= ' '){
            check = true;
            symbol = board[1][1];
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1]!= ' '){
            check = true;
            symbol = board[1][0];
        }

        if (check) {
            writeBoard();
            System.out.println("Wygral " + symbol);
        }

        return check;
    }

//    public boolean isEmptyPosition(int row, int col) {}


}
