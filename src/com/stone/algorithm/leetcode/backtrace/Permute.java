package com.stone.algorithm.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> ans = new Permute().permute(nums);

        for(List<Integer> one : ans) {
            System.out.println("one = " + one);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> one = new ArrayList<>();
        doPermute(nums, one, ans);

        return ans;
    }

    public void doPermute(int[] nums, List<Integer> one, List<List<Integer>> ans) {

        if(one.size() == nums.length) {
            ans.add(new ArrayList<>(one));   //
            return;
        }

        for(int i = 0; i<nums.length; i++) {
            Integer item = nums[i];
            if(one.contains(item)) {
                continue;
            }
            one.add(item);
            doPermute(nums, one, ans);
            one.remove(item);
        }
    }
}
