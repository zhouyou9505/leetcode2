package com.leetcode.动态规划;

public class MinDistance72 {

    /**
     * 动态规划二位数组
     */
    public int minDistance(String word1, String word2) {


        /*

        1、最少，这种字眼，首先考虑动态规划
        2、拆分成最优子问题，word1(abcde)变成word2(fgh)的上一步，一定是从
        (1)word1(abcd->fg) 经过 新增 变成的word2(fgh)
        (2)word2(fg->abcd) 经过 新增 变成的word1(abcde)
        (3)word1(abcd->fg) 经过把最后e改成h 变成的word2(fgh)，如果最后一位正好是h，那都不用改了，只看abcd->fg的编辑距离

        */
        int len1= word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        //初始化数据，word1到‘’的编辑距离
        for(int i = 0;i<=len1;i++){
            dp[i][0] = i;
        }
        for(int j = 0;j<=len2;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                int a = dp[i-1][j] + 1;
                int b = dp[i][j-1] + 1;
                int c = dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0:1);
                dp[i][j] = Math.min(a,Math.min(b,c));
            }
        }

        return dp[len1][len2];

    }
}
