package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class ExtendedBoard implements Board {

    char[][] board = new char[10][10];

    public ExtendedBoard() {
        createBoard();
    }

    @Override
    public void createBoard() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                board[r][c] = ' ';
            }
        }
    }

    @Override
    public void printBoard() {
        System.out.println("\n   A B C D E F G H I J");
        for (int i = 0; i < 10; i++) {
            if(i<9)
                System.out.print((i+1) + " |");
            else
                System.out.print((i+1) + "|");
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }

    }

    @Override
    public void setOnPosition(int col, int row, char symbol) throws FieldAlreadyTakenException {
        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            printBoard();
        } else {
            throw new FieldAlreadyTakenException("To miejsce jest juz zajete.");
        }
    }

    @Override
    public boolean checkBoard() {
        for (int i = 0; i < board.length; i++) {
            // Check rows
            for (int col = 0; col < board.length - 4; col++) {
                if (board[i][col] == board[i][col+1] &&
                        board[i][col+1] == board[i][col+2] &&
                        board[i][col+2] == board[i][col+3] &&
                        board[i][col+3] == board[i][col+4] &&
                        board[i][col+4] != ' ') {
                    return true;
                }
            }
            // Check columns
            for (int row = 0; row < board.length - 4; row++) {
                if (board[row][i] == board[row+1][i] &&
                        board[row+1][i] == board[row+2][i] &&
                        board[row+2][i] == board[row+3][i] &&
                        board[row+3][i] == board[row+4][i] &&
                        board[row+4][i] != ' ') {
                    return true;
                }
            }
        }

        // Check diagonal lines
        for (int row = 0; row < board.length - 5; row++) {

            for (int col = 0; col < board.length - 4; col++) {
                if (board[row][col] == board[row + 1][col + 1] &&
                        board[row + 1][col + 1] == board[row + 2][col + 2] &&
                        board[row + 2][col + 2] == board[row + 3][col + 3] &&
                        board[row + 3][col + 3] == board[row + 4][col + 4] &&
                        board[row + 4][col + 4] != ' ') {
                    return true;
                }
            }

            for (int col = board.length - 1; col >= 4; col--) {
                if (board[row][col] == board[row + 1][col - 1] &&
                        board[row + 1][col - 1] == board[row + 2][col - 2] &&
                        board[row + 2][col - 2] == board[row + 3][col - 3] &&
                        board[row + 3][col - 3] == board[row + 4][col - 4] &&
                        board[row + 4][col - 4] != ' ') {
                    return true;
                }
            }
        }



        return false;
    }

    @Override
    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char element : row) {
                if (element == ' ') return false;
            }
        }
        return true;
    }

    @Override
    public List<int[]> getEmptyPositions() {
        List<int[]> emptyPositions = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    emptyPositions.add(new int[] {col, row});
                }
            }
        }
        return emptyPositions;
    }
}
