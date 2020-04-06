package com.stone.algorithm.leetcode.dp;

/**
 * @Description:
 * @author: donghua
 * @date: 2020-04-06
 */
public class WordDistance {

    public static final void main(String[] args) {
        String word1 = "horse", word2 = "ros";

        int distance = new WordDistance().minDistance(word1, word2);

        /**
         * horse -> rorse -> rose -> ros
         * distance: 3
         */
        System.out.println("distance:" + distance);
    }

    /**
     * word1 经过多少次变化 变为 word2
     *
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            dp[i][0] = i;
        }

        for(int j=0; j<=n; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 神奇的状态转移方程，真心不懂
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

}
