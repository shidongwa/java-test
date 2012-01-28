package com.stone.javacore;
import static java.lang.System.out;

public class InitializerDemo {
    public InitializerDemo() {
        out.println("in constructor");           // Fourth
    }

    static {
        out.println("in static initializer");     // First 
    }

    {
        out.println("in instance initializer");   // Third
    }

    public static void main(String[] args) {
        out.println("in main() method");          //second
        new InitializerDemo();
    }
}  
