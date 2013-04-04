package com.stone.algorithm;

/**
 * 求最大公约数和最小公倍数
 */

public class CommonNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonNumber cn = new CommonNumber();
		int m=8, n=6;
		System.out.println("Greatest common divisor for " + m + " and " + n + " is:" + cn.greatestCommonDivisor(m, n));
		System.out.println("Least common multiple for " + m + " and " + n + " is:" + cn.leastCommonMultiple(m, n));
	}

	/**
	 * 求两数的最大公约数
	 */
	public int greatestCommonDivisor(int m, int n) {
		if (m % n == 0) {
			return n;
		} else {
			return greatestCommonDivisor(n, m % n);
		}
	}

	/**
	 * 求两数的最小公倍数
	 */
	public int leastCommonMultiple(int a, int b) {
		int gbs = 0;
		gbs = a * b / greatestCommonDivisor(a, b);
		return gbs;
	}

}
