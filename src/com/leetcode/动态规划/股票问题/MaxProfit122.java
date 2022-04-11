package com.leetcode.动态规划.股票问题;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit122 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
//        new MaxProfit122().maxProfit(arr);
    }


    /**
     * 成交1次和成交N次最大的区别就是
     * 再求max的时候 今天是不持有的，今天的身价是从前面多次买卖产生的积累收益 + 今天的买卖。
     * 但是1次的话，之前是不允许有交易的， dp[i][0] = Math.max(dp[i - 1][1] + prices[i], 0);
     * dp[i][1] = Math.max(dp[i - 1][1], 状态0不持有 - prices[i]);  但是无限次交易状态不持有可能不是身价0
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //0表示不持有，1表示持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);  //
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];

    }


}
