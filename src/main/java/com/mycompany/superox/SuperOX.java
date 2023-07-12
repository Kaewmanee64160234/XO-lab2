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
    public static String row;
    public static String column;
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

    public static void main(String[] args) {
        startGame();
        while (!isEnd) {
            System.out.println("strart Game");
        }
        System.out.println("end");
    }
}
