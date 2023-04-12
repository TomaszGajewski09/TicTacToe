package com.kodilla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class TicTacToeApplicationTests {

    @Test
    void playerOWinsByRowTest() throws FieldAlreadyTakenException {
        //Given
        BasicBoard basicBoard = new BasicBoard();
        basicBoard.setOnPosition(0,0,'O');
        basicBoard.setOnPosition(1,0,'O');
        basicBoard.setOnPosition(2,0,'O');
        //When
        boolean result = basicBoard.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerOWinsByColumnTest() throws FieldAlreadyTakenException {
        //Given
        BasicBoard basicBoard = new BasicBoard();
        basicBoard.setOnPosition(0,0,'O');
        basicBoard.setOnPosition(0,1,'O');
        basicBoard.setOnPosition(0,2,'O');
        //When
        boolean result = basicBoard.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerOWinsByDiagonalTest() throws FieldAlreadyTakenException {
        //Given
        BasicBoard basicBoard = new BasicBoard();
        basicBoard.setOnPosition(0,0,'O');
        basicBoard.setOnPosition(1,1,'O');
        basicBoard.setOnPosition(2,2,'O');
        //When
        boolean result = basicBoard.checkBoard();
        //Then
        assertTrue(result);
    }
    @Test
    void playerXWinsByRowTest() throws FieldAlreadyTakenException {
        //Given
        BasicBoard basicBoard = new BasicBoard();
        basicBoard.setOnPosition(0,0,'O');
        basicBoard.setOnPosition(1,0,'O');
        basicBoard.setOnPosition(2,0,'O');
        //When
        boolean result = basicBoard.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerXWinsByColumnTest() throws FieldAlreadyTakenException {
        //Given
        BasicBoard basicBoard = new BasicBoard();
        basicBoard.setOnPosition(0,0,'O');
        basicBoard.setOnPosition(0,1,'O');
        basicBoard.setOnPosition(0,2,'O');
        //When
        boolean result = basicBoard.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void playerXWinsByDiagonalTest() throws FieldAlreadyTakenException {
        //Given
        BasicBoard basicBoard = new BasicBoard();
        basicBoard.setOnPosition(0,0,'O');
        basicBoard.setOnPosition(1,1,'O');
        basicBoard.setOnPosition(2,2,'O');
        //When
        boolean result = basicBoard.checkBoard();
        //Then
        assertTrue(result);
    }

    @Test
    void ifDrawTest() throws FieldAlreadyTakenException {
        //Given
        BasicBoard basicBoard = new BasicBoard();
        basicBoard.setOnPosition(0,1,'O');
        basicBoard.setOnPosition(1,1,'O');
        basicBoard.setOnPosition(1,2,'O');
        basicBoard.setOnPosition(2,0,'O');
        basicBoard.setOnPosition(0,0,'X');
        basicBoard.setOnPosition(0,2,'X');
        basicBoard.setOnPosition(1,0,'X');
        basicBoard.setOnPosition(2,1,'X');
        basicBoard.setOnPosition(2,2,'X');

        //When
        boolean result = basicBoard.isBoardFull();

        //Then
        assertTrue(result);

    }
}
