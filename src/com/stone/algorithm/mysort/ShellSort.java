package com.stone.algorithm.mysort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };// plz use sophisticated random
												// number generator
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(shellSort(a)));
	}

	// Performs a shell sort on an array of ints.
	public static int[] shellSort(int[] array) {
		int h = 1;
		while (h < array.length)
			h = 3 * h + 1;
		while (h > 0) {
			h = h / 3;
			for (int k = 0; k < h; k++) {
				for (int i = h + k; i < array.length; i += h) {
					int key = array[i];
					int j = i - h;
					while (j >= 0 && array[j] > key) {
						array[j + h] = array[j];
						j -= h;
					}
					array[j + h] = key;
					// -> invariant: array[0,h,2*h..j] is sorted
				}
			}
			// ->invariant: each h-sub-array is sorted
		}
		return array;
	};
}
