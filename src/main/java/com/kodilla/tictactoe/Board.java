package com.kodilla.tictactoe;

public class Board {

    char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    public Board() {

    }

    public void printBoard() {
        System.out.println("\n  A B C");
        for (int i = 0; i < 3; i++) {
            System.out.print((i+1) + "|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void setOnPosition(int col, int row, char symbol) throws FieldAlreadyTakenException {

        if (board[row][col] == ' ') {
            board[row][col] = symbol;
        } else {
            throw new FieldAlreadyTakenException("To miejsce jest juz zajete.");
        }
    }


    public boolean checkBoard() {
        boolean check = false;

        for (int i = 0; i < 3; i++) {

            // Check rows
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]  && board[i][0]!= ' ') {
                check = true;
            }

            // Check columns
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i]!= ' ') {
                check = true;
            }
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1]!= ' '){
            check = true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1]!= ' '){
            check = true;
        }

        return check;
    }

    public boolean isBoardFull() {
        boolean result = true;
        for (char[] row : board) {
            for (char element : row) {
                if (element == ' ') result = false;
            }
        }
        return result;
    }



}
