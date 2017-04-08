package com.stone.algorithm;

import java.util.Arrays;

/**
 * Created by shidonghua on 2017/4/8.
 *
 * 比如：p={1,2,3}
 *  1.先实现p1={2,3}的全排列，递归
 *  2.实现p11={3}的全排列，perm(p11)={3};
 *  3.实现p12={2}的全排列，perm(p12)={2};
 *  得到：perm(p1)={2,3; 3,2}
 * 最后的算法，就是实现数据的交换（但是注意，交换后要将数据交换回来，避免打乱数组）
 */
public class Permutation {
    //s表示，从array[start]后的数据进行全排列
    public static void permute(int[] array, int start) {
        if (start == array.length) {  // 输出
            System.out.println(Arrays.toString(array));
        } else
            for (int i = start; i < array.length; ++i) {
                swap(array, start, i);  //  交换元素
                permute(array, start + 1);  //交换后，再进行全排列算法
                swap(array, start, i);  //还原成原来的数组，便于下一次的全排列
            }
    }

    private static void swap(int[] array, int s, int i) {
        int t = array[s];
        array[s] = array[i];
        array[i] = t;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        permute(array, 0);
    }
}
