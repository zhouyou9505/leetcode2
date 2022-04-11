package com.leetcode.动态规划.股票问题;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit123 {

    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        new MaxProfit123().maxProfit(arr);
    }


    /**
     * 理解题目意思：最多可以完成两笔交易
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        /**
         * 第i天第n次交易持有/不持有 的身价
         */
        int[][][] dp = new int[prices.length][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] =  -prices[0];  // TODO: 最多可以完成两笔交易,所以 -prices[0] ,因为这个可能是第一笔交易的结果

        for (int i = 1; i < prices.length; i++) {
            //第一次交易
            //第i天 1次交易，不持有：前一天不持有->不持有。   前一天持有->今天卖
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            //第i天 1次交易，持有：前一天不持有，今天持有。   前一天持有-今天不变
            dp[i][1][1] = Math.max(-prices[i], dp[i - 1][1][1]);

            //第2次交易 和 第一次交易的关联就是：  第二次的持有的，是由第一次不持有，购买
            //第二次不持有：前一天不持有不变，第二次交易的持有+卖出
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            //第二次持有：第二次交易前一天持有不变，第一次交易完成后 + 购买
            dp[i][2][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][2][1]);
        }

        return dp[prices.length - 1][2][0];
    }


    /**
     * 空间O(1)
     * 因为动态规划只跟-1有关系，所以 profit1 = profit1 + xx 一定是新profit1和旧profit1
     */
    public int maxProfit_O1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //第i天 n次交易，持有/不持有的 收益
        int profit10 = 0;
        int profit11  = -prices[0];
        int profit20 = 0;
        int profit21 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //第一次交易：不持有
            profit10 = Math.max(profit10, profit11 + prices[i]);
            //第一次交易：持有
            profit11 = Math.max(profit11, -prices[i]);


            //第二次交易：不持有
            profit20 = Math.max(profit20, profit21 + prices[i]);
            //第二次交易：持有
            profit21 = Math.max(profit21, profit10 - prices[i]);
        }
        return profit20;
    }
}

