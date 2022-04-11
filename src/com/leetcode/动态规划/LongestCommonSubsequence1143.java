package com.leetcode.动态规划;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence1143().longestCommonSubsequence("abc", "bc"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * 暴力解法
         * text1中的每个字符都去tex2中，遍历一下，如果有相同的，那么就把text1继续延伸一下和text2的下一个比较，
         * 但是最好用东西记住一下之前存过的状态，好流转到下一次字符相同。不然又要重新计算
         * a b c d e
         * b f d e
         * 其实分为a去b中遍历，b去a中遍历。要把相同字符时的当前状态保存下来，但是dp[i]并不能保存a去b 和 b去a 两种。所以就 dp[i][j] dp[j][i]
         * 重复计算：  text2中f去遍历了一遍，d没必要再去遍历一遍，因为我知道d一定时大于等于 dp[f]
         *
         * 二位表格
         */
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            char a = text1.charAt(i-1);
            for (int j = 1; j <= text2.length(); j++) {
                char b = text2.charAt(j-1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
