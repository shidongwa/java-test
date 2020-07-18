package com.stone.javacore;

import java.util.Arrays;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 7/18/20 07:54
 * @Version: 1.0
 */
public class TestNew {

    public static void main(String[] args) {
        // 局部变量数组中primitive类型默认初始化，同成员变量。猜猜因为数组是分配在堆上
        boolean[] arr = new boolean[5];
        System.out.println("arr:" + Arrays.toString(arr));
        // 局部变量数组中对象类型默认初始化为null，同成员变量
        Integer[] objs = new Integer[5];
        System.out.println("objs:" + Arrays.toString(objs));

        // 局部变量必须初始化，否则编译不通过
        boolean flag;
        //System.out.println("flag:" + flag);
    }
}
