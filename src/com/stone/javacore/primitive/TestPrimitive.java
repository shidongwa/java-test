package com.stone.javacore.primitive;

public class TestPrimitive {


    /**
     * int.class 和 Interger.Type 是等价的，都是int对应的Class对象, 主要用在反射调用参数中
     * Integer.class是int.class的wrapper类；int.class是primitive类
     *
     * @param args
     */
    public static void main(String[] args) {
        Class c1 = int.class;
        Class c2 = Integer.TYPE;
        Class c3 = Integer.class;

        System.out.println("c1 == c2 : " + (c1 == c2));
        System.out.println("c1 == c3 : " + (c1 == c3));

        System.out.println("c1 is primitive : " + c1.isPrimitive());
        System.out.println("c2 is primitive : " + c2.isPrimitive());
    }

}
