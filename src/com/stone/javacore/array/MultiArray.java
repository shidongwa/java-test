package com.stone.javacore.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiArray {

    /**
     * 第一种初始化方式不正确。graph[0]数组中每个元素存储的是同一个new ArrayList对象。不符合图的邻接表数据结构要求
     * 第二种初始化方式正确
     * @param args
     */
    public static void main(String[] args) {
        int n = 5;
        List<Integer>[][] graph1 = new List[2][n];
        for(int i = 0; i < 2; i++) {
            // 第一种初始化方式
            Arrays.fill(graph1[i], new ArrayList<>());
        }

        System.out.println("graph1[0]:" + Arrays.toString(graph1[0]));
        System.out.println("graph1[1]:" + Arrays.toString(graph1[1]));


        //
        List<Integer>[][] graph2 = new List[2][n];
        for(int i = 0; i < 2; i++) {
            // 第二种初始化方式
            for(int j = 0; j < n; j++) {
                graph2[i][j] = new ArrayList<>();
            }
        }

        System.out.println("graph2[0]:" + Arrays.toString(graph2[0]));
        System.out.println("graph2[1]:" + Arrays.toString(graph2[1]));
    }
}
