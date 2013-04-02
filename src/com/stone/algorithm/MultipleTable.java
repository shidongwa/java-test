package com.stone.algorithm;

/**
 * 九九乘法表
 * @author dong
 *
 */
public class MultipleTable {

    public static void main(String args[]) {
        for(int a=1; a<10; a++) {
            for(int b=1; b <= a; b++) {
                System.out.print(a +"x"+ b +"="+ a*b+"    ");
                if(a == b) {
                    System.out.println();
                }
            }
        }    
    }

}
