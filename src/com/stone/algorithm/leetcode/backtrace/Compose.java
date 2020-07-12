package com.stone.algorithm.leetcode.backtrace;

import java.util.Stack;

/**
 * @Author: shidonghua
 * @Description: 组合数
 * @Date: 6/30/20 11:31
 * @Version: 1.0
 */
public class Compose {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4};

        Stack<Integer> stack = new Stack<>();
        _compose(arr, stack, 3);
    }

    private static void _compose(int[] arr, Stack<Integer> stack, int cnt) {
        if(stack.size() == cnt) {
            System.out.println(stack);
        }

        for(int i = 0; i < arr.length; i++) {
            if(!stack.contains(arr[i])) {
                stack.push(arr[i]);
                _compose(arr, stack, cnt);
                stack.pop();
            }
        }
    }
}
