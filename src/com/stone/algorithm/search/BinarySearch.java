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
    public int bsearch_LeftMost(int[] a, int n, int value) {
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

    /**
     * 二分搜索最右边的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch_RightMost(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid; // 往右边逼近
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 第一个大于等于元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch_GE(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 最后一个小于等于
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch_LE(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
}

