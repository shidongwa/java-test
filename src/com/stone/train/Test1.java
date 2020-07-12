
package com.stone.train;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 6/30/20 13:23
 * @Version: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        int x = 1;
        List<Integer> arr = Arrays.asList(1, 2, 3, 1, 2);

        int ans = segment(2, arr);

        System.out.println("ans:" + ans);
    }

    /*
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER_ARRAY arr
     */
    public static int segment(int x, List<Integer> arr) {
        int size = arr.size();
        //?
        if(x > size) {
            return -1;
        }

        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;

        // 初始化初始窗口
        while(r < x) {
            min = Math.min(min, arr.get(r));
            ++r;
        }

        int ans = min;

        // 最小值是最左边的元素时需要从剩下的元素中找到新的最小值
        if(min == arr.get(l)) {
            min = getMin(arr, l+1, r);
        }

        // 滑动窗口并找每一个窗口中的最小值
        while(r < size - x) {
            ++l;
            min = Math.min(arr.get(r), min);

            // 更新当前找到的答案
            if(min > ans) {
                ans = min;
            }

            if(min == arr.get(l)) {
                min = getMin(arr, l+1, r);
            }

            ++r;
        }

        return ans;
    }

    private static int getMin(List<Integer> arr, int l, int r) {
        int min = Integer.MAX_VALUE;
        for(int i = l; i < r; i++) {
            min = Math.min(arr.get(i), min);
        }

        return min;
    }
}
