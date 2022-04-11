package com.leetcode.动态规划;

import java.util.Arrays;

public class UniquePaths62 {

    public static void main(String[] args) {
        System.out.println(new UniquePaths62().uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0],1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
