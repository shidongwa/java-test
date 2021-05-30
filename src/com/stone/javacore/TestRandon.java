package com.stone.javacore;

import java.util.Random;

/**
 * @Author: shidonghua
 * @Description: 基于同一个seed值1000，新建random对象产生相同的随机序列。解决的方法是用同一个random实例，
 * @Date: 5/30/21 20:32
 * @Version: 1.0
 */
public class TestRandon {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
//            System.out.println("random no is:" + getRndNo());
            System.out.println("random no is:" + getRndNo2());
        }

    }

    public static Integer getRndNo() {
        Random r = new Random(1000);
        return r.nextInt(26);
    }

    private static Random r = new Random(1000);
    public static Integer getRndNo2() {
        return r.nextInt(26);
    }
}
