package com.stone.algorithm.search;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 3/8/21 09:07
 * @Version: 1.0
 */
public class BinarySearch {

    /**
     * 二分搜索，并找最左边的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid; // 最左逼近
                else high = mid - 1;
            }
        }
        return -1;
    }
}
