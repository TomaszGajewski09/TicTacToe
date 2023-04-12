package com.kodilla.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu {

    private boolean versusComputer;
    private boolean basicBoard;
    Scanner scanner = new Scanner(System.in);
    public UserMenu() {
        System.out.println("Witaj w grze Kolko i Krzyzyk!");
        chooseOpponent();
        chooseBoard();
    }

    private void chooseOpponent() {
        System.out.println("Z kim chcesz zagrać? (wpisz numer): ");
        System.out.println("1. Gra przeciwko graczowi.");
        System.out.println("2. Gra przeciwko komputerowi.");
        String input = scanner.nextLine();

        if (input.matches("^[1-2]$")) {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    this.versusComputer = false;
                    break;
                case 2:
                    this.versusComputer = true;
                    break;
            }
        } else {
            System.out.println("Nieprawidlowy wybor. Wybierz numer 1 lub 2.");
            chooseOpponent();
        }
    }

    private void chooseBoard() {
        System.out.println("W jaki tryb chcesz zagrac? (wpisz numer): ");
        System.out.println("1. Kolko i krzyzyk");
        System.out.println("2. Kolko i krzyzyk do pieciu");
        String input = scanner.nextLine();

        if (input.matches("^[1-2]$")) {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    this.basicBoard = true;
                    break;
                case 2:
                    this.basicBoard = false;
                    break;
            }
        } else {
            System.out.println("Nieprawidlowy wybor. Wybierz numer 1 lub 2.");
            chooseOpponent();
        }
    }

    public boolean isVersusComputer() {
        return versusComputer;
    }

    public boolean isBasicBoard() {
        return basicBoard;
    }
}
