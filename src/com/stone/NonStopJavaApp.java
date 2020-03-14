package com.stone;

import java.io.IOException;

public class NonStopJavaApp {

    public static void main(String[] args) {
        System.out.println("Java is running...");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Exit now.");
    }
}
