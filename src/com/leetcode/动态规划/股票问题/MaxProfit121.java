package com.leetcode.动态规划.股票问题;

import java.util.Arrays;

/**
 * T[i][1][0] = max(T[i - 1][1][0], T[i - 1][1][1] + prices[i])
 * T[i][1][1] = max(T[i - 1][1][1], T[i - 1][0][0] - prices[i]) = max(T[i - 1][1][1], -prices[i])
 * <p>
 * https://leetcode-cn.com/circle/article/qiAgHn/  股票系列问题
 * <p>
 * 重复子问题
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/python3jian-dan-yi-dong-cong-naivebao-li-jie-fa-ga/
 */
public class MaxProfit121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 2, 4, 8, 9};
        System.out.println(new MaxProfit121().maxProfit2(prices));
    }


    /**
     * 最大收益就是当天的价格 减去 之前价格最低的一天。
     */
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }


    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length+1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(-prices[i-1], dp[i-1][1]);
        }

        return dp[prices.length][0];
    }

    /**
     * 空间复杂度 O(1)
     */
    public int maxProfit2_O1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit0 = 0;
        int profit1 = -prices[0];

        for (int i = 0; i < prices.length; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(-prices[i], profit1);
        }

        return profit0;
    }
}
