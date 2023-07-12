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

    public static void inputRowAndColumn() {
        showTurn();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Row :");
        row = sc.nextInt();
        System.out.print("Input Column :");
        column = sc.nextInt();
        if ((row > 0 && row < 4) && (column > 0 && column < 4)) {
            while ((!(row > 0 && row < 4) && !(column > 0 && column < 4)) && !(board[row - 1][column - 1].equals("-"))) {
                showTurn();
                System.out.print("Input Row :");
                row = sc.nextInt();
                System.out.print("Input Column :");
                column = sc.nextInt();
            }
            board[row - 1][column - 1] = turn;
        } else {
            return;
        }

    }

    public static void main(String[] args) {
        turn = "X";
//        startGame();
      
        showBoard();
        while (!isEnd) {
           inputRowAndColumn();
             showBoard();
            
        }
//        System.out.println("end");
    }
}
