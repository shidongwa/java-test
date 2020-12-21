package com.stone.javacore.exception;

/**
 * @Author: shidonghua
 * @Description: finally 中不会执行的特例
 * 1，不要在 finally 中使用 return 语句。
 * 2，finally 总是执行，除非程序或者线程被中断
 * @Date: 12/21/20 08:18
 * @Version: 1.0
 */
public class TestFinally {
    public static void main(String[] args) {
        try {
            // do something
            System.out.println("Print from try");
            System.exit(1);
        } finally{
            System.out.println("Print from finally");
        }
    }
}
