package com.kodilla.tictactoe;

import java.util.List;

public interface Board {


    void createBoard();
    void printBoard();
    void setOnPosition(int col, int row, char symbol) throws FieldAlreadyTakenException;
    boolean checkBoard();
    boolean isBoardFull();
    List<int[]> getEmptyPositions();

}
