package com.stone.algorithm.leetcode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串
 */
public class Palindrome {

    public static void main(String[] args) {
        String in = "eeccccbebaeeabebccceea";
        boolean isPalindrome = new Palindrome().validPalindrome(in);

        System.out.println("isPalindrome:" + isPalindrome);
    }

    public boolean validPalindrome(String s) {
        int size = s.length();

        int i = 0, j = size - 1;
        boolean isPalindrome = true;
        boolean flag1 = true;
        boolean flag2 = true;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                int p = i, q = j;
                // 右边去掉一个字符
                if(s.charAt(p) == s.charAt(q-1)) {
                    q--;
                    while(p<q) {
                        if(s.charAt(p) != s.charAt(q)) {
                            flag1 = false;
                            break;
                        }
                        p++;
                        q--;
                    }
                } else {
                    flag1 = false;
                }

                // 必须保留i，j位置，右边忽略没有成功时尝试从左边忽略
                if(!flag1) {
                    p = i;
                    q = j;
                    // 左边去掉一个字符
                    if(s.charAt(p+1) == s.charAt(q)) {
                        p++;
                        while(p < q) {
                            if(s.charAt(p) != s.charAt(q)) {
                                flag2 = false;
                                break;
                            }
                            p++;
                            q--;
                        }
                    } else {
                        flag2 = false;
                    }
                }

                isPalindrome = flag1 || flag2;
                break;
            }
        }

        return isPalindrome;
    }

}
