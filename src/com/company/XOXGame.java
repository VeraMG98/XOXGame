package com.company;

import java.util.Random;
import java.util.Scanner;

public class XOXGame {
    final char X = 'x';
    final char O = 'o';
    final char EMPTY = '.';
    char[][] xoxTable;
    Random random;
    Scanner scanner;

    public XOXGame() {
        random = new Random();
        scanner = new Scanner(System.in);
        xoxTable = new char[3][3];
    }

    public void game() {
        initXoxTable();
        while (true){
            turnGamer();
            if (win(X)){
                System.out.println("You win");
                break;
            }
            if (isXoxTableFull()){
                System.out.println("Sorry, draw");
                break;
            }
            turnPc();
            if (win(O)){
                System.out.println("Pc win");
                break;
            }
            if (isXoxTableFull()){
                System.out.println("Sorry, draw");
                break;
            }
        }
        System.out.println("Game over");
        printXoxTable();
    }

    private void initXoxTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xoxTable[i][j] = EMPTY;
            }
        }
    }

    private void turnGamer() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellValid(x, y));
        xoxTable[y][x] = X;
    }

    private void turnPc() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (isCellValid(x, y));
        xoxTable[y][x] = O;
        printXoxTable();
    }

    boolean isXoxTableFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (xoxTable[i][j] == EMPTY)
                    return false;
        return true;
    }

    private void printXoxTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(xoxTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3|| y >= 3)
            return true;
        return xoxTable[y][x] != EMPTY;
    }

    boolean win(char win) {
        for (int i = 0; i < 3; i++)
            if ((xoxTable[i][0] == win && xoxTable[i][1] == win &&
                    xoxTable[i][2] == win) ||
                    (xoxTable[0][i] == win && xoxTable[1][i] == win &&
                            xoxTable[2][i] == win))
                return true;
        return (xoxTable[0][0] == win && xoxTable[1][1] == win &&
                xoxTable[2][2] == win) ||
                (xoxTable[2][0] == win && xoxTable[1][1] == win &&
                        xoxTable[0][2] == win);
    }


}
