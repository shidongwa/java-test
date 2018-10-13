package com.stone.test;

import java.io.IOException;
import java.util.Scanner;

public class PendingApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("press any character and exit");

        // solution 1
//        System.in.read(); // #7

        // solution 2
        new Scanner(System.in).nextLine();
    }
}
