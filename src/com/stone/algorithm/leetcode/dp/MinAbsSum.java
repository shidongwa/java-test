package com.stone.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/
 * {-1, 1}, 数组中元素乘以1或者-1，使得和尽量接近0
 */
public class MinAbsSum {
    // dp[j] = −1 if we cannot get the sum j,
    // dp[j] >= 0 if we can get sum j. dp[j] denotes how many values a remain (maximally) after achieving sum j，
    // 值为满足sum j时有还剩下多少个a。这个dp值是这个题解中最难理解的地方

    private static int[] dp;

    public static void main(String args[]) {
        int[] array = {1, 5,  2, -2};

        System.out.println(findMinAbsSum(array));
    }

    public static int findMinAbsSum(int[] A) {
        int arrayLength = A.length;
        int M = 0;
        for (int i = 0; i < arrayLength; i++) {
            A[i] = Math.abs(A[i]); // 统一转化为正数，问题转化为数组分为2部分，第一部分和尽量接近和的一半（小于一半但是尽量接近一半）
            M = Math.max(A[i], M);
        }

        int S = sum(A);
        dp = new int[S + 1];
        int[] count = new int[M + 1];
        for (int i = 0; i < arrayLength; i++) {
            count[A[i]] += 1; // 每个数字出现的次数，从题目看最多100个数字
        }
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < M + 1; i++) {
            if (count[i] > 0) {
                for(int j = 0; j < S; j++) {
                    if (dp[j] >= 0) { // 已有解，
                        dp[j] = count[i];
                    } else if (j >= i && dp[j - i] > 0) { // 当前还没有解，但是更小问题空间上有解
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }
        int result = S;
        for (int i = 0; i < Math.floor(S / 2) + 1; i++) { // 有解的解空间中找最小值
            if (dp[i] >= 0) {
                result = Math.min(result, S - 2 * i);
            }
        }
        return result;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for(int i : array) {
            sum += i;
        }

        return sum;
    }
}
