package com.stone.algorithm.leetcode.backtrace;

import java.util.Stack;

/**
 * @Author: shidonghua
 * @Description: 全排列
 * @Date: 6/30/20 11:23
 * @Version: 1.0
 */
public class Permute2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Stack<Integer> stack = new Stack<>();
        _permute(arr, stack);
    }

    private static void _permute(int[] arr, Stack<Integer> stack) {
        if(stack.size() == arr.length) {
            System.out.println(stack.toString());
        }

        for(int i = 0; i < arr.length; i++) {
            if(!stack.contains(arr[i])) {
                stack.push(arr[i]);
                _permute(arr, stack);
                stack.pop();
            }
        }
    }
}
