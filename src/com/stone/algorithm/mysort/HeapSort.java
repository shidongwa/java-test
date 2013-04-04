package com.stone.algorithm.mysort;

import java.util.Arrays;

/**
 * 基于最大堆的堆排序
 * @author dong
 *
 */
public class HeapSort {

	/**
	 * 向下调整堆。
	 * 建堆时从最后一个分支节点开始直到叶节点
	 * 排序时从根节点到未排好序的最后一个节点
	 * @param arr
	 * @param s
	 * @param t
	 */
	public static void heapAdjust(int[] arr, int s, int t) {		

		for(int j = s; j<t;){
			int left = 2 * j + 1;
			int right = left + 1;
			int max = left; //左右子节点中小的节点,默认为左子节点			
			if(left > t){
				break; //exit now
			}else if(right <= t && arr[right] > arr[left]){
				max = right;
			}

			if(arr[j] < arr[max]){				
				swap(arr, j, max);
				j = max;
			}else{
				break; //exit now
			}
			
		}
	}

	/**
	 * 最大堆堆排序
	 * @param arr
	 */
	public static void sort(int[] arr) {
		
		//从最后一个非叶节点起调整堆，使得左右子节点值都比该分支节点值小
		for (int i = (arr.length - 1) / 2; i >= 0; --i){
			heapAdjust(arr, i, arr.length - 1);			
		}

		//把堆顶元素与最后一个节点交换，然后重新调整堆，循环arr.length-1次即可得到升序排列
		for (int j = arr.length - 1; j >= 1; --j) {
			swap(arr, 0, j);

			heapAdjust(arr, 0, j - 1);
		}
	}
	
	/**
	 * 交换数组中的两个元素值
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}	

	
	public static void main(String[] args){
		int[] array = {9,7,2,8,5,10,1,22,17,18};
		System.out.println("input:" + Arrays.toString(array));
		HeapSort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
