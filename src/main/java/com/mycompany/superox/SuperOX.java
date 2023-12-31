/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.superox;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class SuperOX {

    public static String[][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    public static String turn;
    public static int row;
    public static int column;
    public static boolean isEnd = false;

    public static void startGame() {
        System.out.println("Welcome to XO Game");
        System.out.print("Start XO Games? (Y/N) :");
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toLowerCase();
        while (!input.equals("y") && !input.equals("n")) {
            System.out.println("Welcome to XO Game");
            System.out.print("Start XO Games? (Y/N) :");
            input = sc.next().toLowerCase();
        }
        if (input.equals("n")) {
            isEnd = true;
        } else {
            isEnd = false;
        }
    }

    public static void showBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();

        }
    }

    public static void showTurn() {
        System.out.println("Turn>>> " + turn.toUpperCase());
    }

    public static boolean inputRowAndColumn() {
        System.out.println("--------------------------------");
        showTurn();

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Row: ");
        row = sc.nextInt();
        System.out.print("Input Column: ");
        column = sc.nextInt();

        if ((row > 0 && row < 4) && (column > 0 && column < 4)) {
            while (!board[row - 1][column - 1].equals("-")) {
                System.out.println("--------------------------------");
                showTurn();
                showBoard();
                System.out.print("Input Row: ");
                row = sc.nextInt();
                System.out.print("Input Column: ");
                column = sc.nextInt();

            }
            board[row - 1][column - 1] = turn;
            return true;
        } else {

            return false;
        }
    }

    public static void changeTurn() {
        if (turn.toUpperCase().equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }

    public static void checkWinner() {

        if (checkRow() || checkColumn() || checkDiagonal()) {
            System.out.println("--------------------------------");

            System.out.println("+--------------------+");
            System.out.println("|    !!! " + turn.toUpperCase() + " Win !!!   |");
            System.out.println("+--------------------+");
            showBoard();
            askContinute();

        } else {
            if (checkDraw()) {
                System.out.println("--------------------------------");

                System.out.println("+--------------------+");
                System.out.println("|    !!! Draw !!!    |");
                System.out.println("+--------------------+");
                showBoard();
                askContinute();

            }
        }

    }

    public static boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (!board[row - 1][i].equals(turn)) {
                return false;
            }

        }
        return true;
    }

    public static boolean checkColumn() {
        for (int i = 0; i < 3; i++) {
            if (!board[i][column - 1].equals(turn)) {
                return false;
            }

        }
        return true;
    }

    public static boolean checkDiagonal() {
        if (row - 1 == column - 1) {
            for (int i = 0; i < 3; i++) {
                if (!board[i][i].equals(turn)) {
                    return false;
                }

            }
            return true;
        }
        if ((row + column) - 2 == 2) {
            for (int i = 0; i < 3; i++) {
                if (!board[i][2 - i].equals(turn)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }

            }

        }
        return true;
    }

    public static void askContinute() {

        System.out.print("You want to play again (Y/N) : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toLowerCase();
        while (!input.equals("y") && !input.equals("n")) {
            System.out.print("You want to play again (Y/N) : ");
            input = sc.next().toLowerCase();
        }
        if (input.equals("n")) {
            isEnd = true;
        } else {
            resetBoard();
            turn = "O";

        }

    }

    public static void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";

            }

        }

    }

    public static void processXO() {
        showBoard();
        while (!isEnd) {
            if (inputRowAndColumn()) {
                showBoard();
                checkWinner();
                changeTurn();
            }

        }
        System.out.println("GoodBye!!");
    }

    public static void main(String[] args) {
        turn = "X";
        processXO();

    }
}
