package com.kodilla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class TicTacToeApplicationTests {

    @Test
    void playerOWinsByRowTest() throws FieldAlreadyTakenException {
        //Given
        Board board = new Board();
        board.setOnPosition(0,0,'O');
        board.setOnPosition(1,0,'O');
        board.setOnPosition(2,0,'O');
        //When
        boolean result = board.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerOWinsByColumnTest() throws FieldAlreadyTakenException {
        //Given
        Board board = new Board();
        board.setOnPosition(0,0,'O');
        board.setOnPosition(0,1,'O');
        board.setOnPosition(0,2,'O');
        //When
        boolean result = board.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerOWinsByDiagonalTest() throws FieldAlreadyTakenException {
        //Given
        Board board = new Board();
        board.setOnPosition(0,0,'O');
        board.setOnPosition(1,1,'O');
        board.setOnPosition(2,2,'O');
        //When
        boolean result = board.checkBoard();
        //Then
        assertTrue(result);
    }
    @Test
    void playerXWinsByRowTest() throws FieldAlreadyTakenException {
        //Given
        Board board = new Board();
        board.setOnPosition(0,0,'O');
        board.setOnPosition(1,0,'O');
        board.setOnPosition(2,0,'O');
        //When
        boolean result = board.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerXWinsByColumnTest() throws FieldAlreadyTakenException {
        //Given
        Board board = new Board();
        board.setOnPosition(0,0,'O');
        board.setOnPosition(0,1,'O');
        board.setOnPosition(0,2,'O');
        //When
        boolean result = board.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerXWinsByDiagonalTest() throws FieldAlreadyTakenException {
        //Given
        Board board = new Board();
        board.setOnPosition(0,0,'O');
        board.setOnPosition(1,1,'O');
        board.setOnPosition(2,2,'O');
        //When
        boolean result = board.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void ifDrawTest() throws FieldAlreadyTakenException {
        //Given
        Board board = new Board();
        board.setOnPosition(0,1,'O');
        board.setOnPosition(1,1,'O');
        board.setOnPosition(1,2,'O');
        board.setOnPosition(2,0,'O');
        board.setOnPosition(0,0,'X');
        board.setOnPosition(0,2,'X');
        board.setOnPosition(1,0,'X');
        board.setOnPosition(2,1,'X');
        board.setOnPosition(2,2,'X');

        //When
        boolean result = board.isBoardFull();

        //Then
        assertTrue(result);

    }
}
