package com.stone.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by shidonghua on 2017/7/22.
 */
public class SortColor {
    public static void main(String[] args) {
        SortColor sc = new SortColor();
        int[] nums = {1, 0, 2, 2, 1, 0};

        System.out.println("排序前:" + Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0, end = nums.length - 1, current = 0;
        while (current <= end) {
            if (nums[current] == 0) {
                swap(nums, start, current);
                start++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, end);
                end--;
            } else {
                current++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
