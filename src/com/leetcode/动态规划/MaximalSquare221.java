package com.leetcode.动态规划;

public class MaximalSquare221 {

    public static void main(String[] args) {

        char[][] arr = {{'1','1','1','1','1'}, {'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'}};
        System.out.println(new MaximalSquare221().maximalSquare(arr));
    }

    public int maximalSquare(char[][] matrix) {

        //纵横0，如果是0就是，1就是1

        //如果 char[i-1][j] ,char[i][j-1]是1,char[i-1][j-1]1 那就dp[i-1][j-1]+1

        //因为是连续的，所以，没有的地方就是dp[i][j]=0

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    }
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max * max;
    }
}
