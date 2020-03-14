package com.stone.algorithm.leetcode;

import java.util.*;

public class GcdOfString {

    public static void main(String[] args) {
        String str1 = "FFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKST";
        String str2 = "FFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKST";

/*        String str1 = "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO";
        String str2 = "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO";*/

        GcdOfString gcd = new GcdOfString();
//        String gcdStr = gcd.gcdOfStrings(str1, str2);
        String gcdStr = gcd.getCommonDivisor(str1, str2);


        System.out.println("gcd:" + gcdStr);
    }

    /**
     * get common string divisor of two String
     * @param str1
     * @param str2
     * @return
     */
    public String getCommonDivisor(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        SortedSet<Integer> divisor1 = getDivisors(len1);
        SortedSet<Integer> divisor2 = getDivisors(len2);
        SortedSet<Integer> intersection = getCommonDivisors(divisor1, divisor2);

        for(Integer num : intersection) {
            String substr = str1.substring(0, num);
            if(isStrDivisor(str1, substr) && isStrDivisor(str2, substr)){
                return substr;
            }
        }

        return "";
    }

    /**
     * check if substr is String divisor of str
     * @param str
     * @param substr
     * @return
     */
    public boolean isStrDivisor(String str, String substr) {
        int len1 = str.length();
        int len2 = substr.length();
        if(len1 % len2 !=0) {
            return false;
        }


        int repeat = len1/len2;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<repeat; i++) {
            sb.append(substr);
        }

        return str.equals(sb.toString());
    }

    /**
     * get divisor list of number
     * @param number
     * @return
     */
    public SortedSet<Integer> getDivisors(int number) {
        SortedSet<Integer> divisors = new TreeSet<>();

        for(int i=1; i<Math.sqrt(number)+1; i++) {
            if(i * number/i == number) {
                divisors.add(i);
                divisors.add(number/i);
            }
        }

        return divisors;
    }

    /**
     * get common divisor list of two numbers in descend order
     * @param set1
     * @param set2
     * @return
     */
    public SortedSet<Integer> getCommonDivisors(SortedSet<Integer> set1, SortedSet<Integer> set2) {
        SortedSet<Integer> intersection = new TreeSet<>(Collections.reverseOrder());
        intersection.addAll(set1);
        intersection.retainAll(set2);

        return intersection;
    }

    public String gcdOfStrings(String str1, String str2) {
        String gd1 = gdOfString(str1);
        System.out.println("gd1:" + gd1);
        String gd2 = gdOfString(str2);
        System.out.println("gd2:" + gd2);

        if( gd1 !=null && gd1.equals(gd2)) {
            return gd1;
        } else {
            return "";
        }
    }

    /**
     * algo not works!!!!!!!!!!!
     * @param str
     * @return
     */
    public String gdOfString(String str) {
        if(str == null || str.length() == 0) {
            return str;
        }

        char[] array = str.toCharArray();
        int start = 0;
        int end = 0;
        int start2 = 0;
        boolean foundEnd = false;
        for (int i=0; i<array.length; i++) {
            if(array[i] == array[start]) {
                if(i == end + 1) {
                    start2 = start; //1. count avoid changing start pos 2. only reset after full match

                    if(!foundEnd) {
                        end = i-1;
                    }
                }

                if(i != 0) { // second time's match
                    foundEnd = true;
                }
            } else if (!foundEnd) {
                end = i;
            }



            if(array[i] == array[start2]) {
                start2++;
            } else {
                foundEnd = false;
                end = i-1; // ABCAABCA, this is the actual end pos

                if(array[i] == array[start]) {
                    start2 = start + 1; // the first one is matched and match the next one
                } else {
                    start2++;
                }
            }
        }

        return str.substring(start, end+1);
    }
}
