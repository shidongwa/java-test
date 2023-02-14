package com.stone.javacore;

import java.util.Random;

/**
 * 相同seed的不同Random实例会生产相同序列的随机数
 */
public class TestRandom {
    public static void main(String[] args) {
        int seed = 1000;
        Random r1 = new Random(seed);
        Random r2 = new Random(seed);
        for(int i = 0; i < 3; i++) {
            System.out.println("r1:" + r1.nextInt(10) + ", r2:" + r2.nextInt(10));
        }
    }
}
