package com.stone.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回大于n/3的元素列表，采用摩尔计数的扩展，用两个count来记录第一/第二多的元素
 */
public class MajorElement {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2};
//        int[] nums = new int[] {2, 2, 1, 3};
        List<Integer> res = new MajorElement().majorityElement(nums);

        System.out.println("res:" + res);
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList(2);
        if(nums == null || nums.length == 0) {
            return res;
        } else if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }

        int count1=0,count2=0;
        int num1=nums[0] , num2 =nums[0];

        for(int i=0; i<nums.length; i++) {
            if(num1 == nums[i]) {
                ++count1;
                continue;
            }

            if(num2 == nums[i]) {
                ++count2;
                continue;
            }

            if(count1 == 0) {
                num1 = nums[i];
                count1 = 1;
                continue;
            }

            if(count2 == 0) {
                num2 = nums[i];
                count2 = 1;
                continue;
            }

            --count1;
            --count2;
        }

        int cnt1 = count(num1, nums);
        int cnt2 = count(num2, nums);

        if(cnt1 > nums.length/3) {
            res.add(num1);
        }

        if(cnt2 > nums.length/3 && num2 != num1) {
            res.add(num2);
        }

        return res;
    }

    public int count(int num, int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++) {
            if(num == nums[i]) {
                ++cnt;
            }
        }

        return cnt;
    }
}
