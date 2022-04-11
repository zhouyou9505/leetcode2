package com.leetcode.动态规划.股票问题;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个整数数组prices，其中第 prices[i] 表示第 i 天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class MaxProfit309 {



    /**
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // i-1天，不进行任何操作。或者  如通过是第i天买入，那么第i-1天就不能持有股票，
            // f[i-1][2]不能持有股票并且不处于冷冻期中，对应的状态f[i-1][2]加入买入股票的负收益prices[i]，因此状态转移方程。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }


}
