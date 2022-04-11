package com.leetcode.动态规划.背包问题.完全背包;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 */
public class CoinChange332 {

    /**
     * 完全背包：
     * 1 2 3 5  , amount = 10
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //dp表示总和j的时候，最小的数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    /**
                     * i==1是 dp[amount]高达10次
                     * ...
                     * i==3,j==10时
                     * dp[4] = min(dp[4],dp[1]+1) 加入选了后面说明
                     * dp[7] = min(dp[7],dp[4]+1)
                     * dp[10] = min(dp[10],dp[7]+1) ,
                     * i==4时：旧dp[j]: 零钱1~零钱3 所使用的最少数量
                     * i==4时:旧dp[j-coins[i]]：多次使用零钱3 所使用的最少的数量
                     * i==4时 新dp[j]: 零钱1~零钱4 所使用的最少数量
                     * i==4时 旧dp[j-coins[i]]:多次使用零钱4 所使用的最少的数量
                     * dp[j-coins[i]]+1: j-coins[i]所使用的最少数量
                     */
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        /**
         * dp[amount] > amount
         * 比如 4  amount=10
         * dp[1~3]>amount
         * dp[4] = 1
         * dp[5~7] = dp[1~3] + 1 >amount
         * dp[8] = dp[4] +1
         * dp[9] = dp[5] + 1 >amount
         * dp[10]  =dp[6] + 1 > amount
         * 说明 dp计算的值>amount说明 amount不能被 零钱整除，也就是不能回溯到dp[0]
         */
        return dp[amount] > amount ? -1:dp[amount];
    }

}
