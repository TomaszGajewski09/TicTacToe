package com.kodilla.tictactoe;

public class FieldAlreadyTakenException extends Exception {
    public FieldAlreadyTakenException(String message) {
        super(message);
    }
}
