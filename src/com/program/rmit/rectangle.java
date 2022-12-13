package com.program.rmit;

import java.util.Scanner;

public class rectangle {
    public static int process() {
        Scanner josh = new Scanner(System.in);
        System.out.println("Enter your FIRST number:");
        int i1 = josh.nextInt();
        Scanner tom = new Scanner(System.in);
        System.out.println("Enter your SECOND number:");
        int i2 = tom.nextInt();
        if (i1 < 0) {
            System.out.println("Invalid number detected!");
            i1 = 1;
        }
        if (i2 < 0) {
            System.out.println("Invalid number detected!");
            i2 = 1;
        }
        for (int a = 0; a < i1; a++) {
            for (int b = 0; b < i2; b++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        return i1;
    }
    public static void main(String args[]) {
        process();
    }
}
