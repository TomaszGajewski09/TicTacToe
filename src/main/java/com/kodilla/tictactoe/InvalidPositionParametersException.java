package com.kodilla.tictactoe;

public class InvalidPositionParametersException extends Exception{
    public InvalidPositionParametersException(String message) {
        super(message);
    }
}
