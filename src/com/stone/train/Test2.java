package com.stone.train;

import java.util.*;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 6/30/20 14:15
 * @Version: 1.0
 */
public class Test2 {
/*
    Input: [1,1,2]
    Output:
            [
            [1,1,2],
            [1,2,1],
            [2,1,1]
            ]

 */

    public static void main(String[] args) {
//        List arr = Arrays.asList(1, 1, 2);
        List arr = Arrays.asList(2, 1, 1);
        Set<List<Integer>> ans = new HashSet<>();
        permute(arr, 0, ans);

        System.out.println("ans:" + ans);
    }

    /**
     * 全排列
     * @param arr
     * @param start
     * @param ans
     */
    public static void permute(List<Integer> arr, int start, Set<List<Integer>> ans) {

        if(start == arr.size() - 1) {
            ans.add(new ArrayList<>(arr));
        }

        for(int i = start; i < arr.size(); i++) {
            swap(arr, start, i);
            permute(arr, start + 1, ans);
            swap(arr, i, start);
        }
    }

    /**
     * 交换列表中元素值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
