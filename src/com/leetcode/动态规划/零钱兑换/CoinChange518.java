package com.leetcode.动态规划.零钱兑换;

import java.util.Arrays;

/**
 * 零钱兑换 II
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * https://leetcode-cn.com/problems/coin-change-2/solution/gong-shui-san-xie-xiang-jie-wan-quan-bei-6hxv/
 * <p>
 * https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
 */
public class CoinChange518 {

    public static void main(String[] args) {
        int amount = 10;
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange518().change(amount, coins));
    }

    public int change(int amount, int[] coins) {

        /**
         * 正确的子问题定义应该是，problem(k,i) = problem(k-1, i) + problem(k, i-coins[k])
         *
         * 即前k个硬币凑齐金额i的组合数等于前k-1个硬币凑齐金额i的组合数加上在原来i-k的基础上使用硬币的组合数。
         * 说的更加直白一点，那就是用前k的硬币凑齐金额i，要分为两种情况计算，
         * 一种是没有用第K个硬币就凑齐了，一种是前面已经凑到了i-coins[k]，现在就差第k个硬币了。
         *
         * 必须选择第k个硬币时，凑成金额i的方案。如果交换了，我们的子问题就变了，那就是对于金额 i, 我们选择硬币的方案。
         *

         * 用金币1，凑 1~10得方案
         * 用金1，2，凑1~10得方案 = 用金币1得方案+用金笔2凑得方案
         *
         * 解题：可以转化成爬楼梯方案
         * 三个疑问：
         * （1）for循环为什么这么写？ 为什么是金额包着amount，因为横轴是金币，纵轴是amount
         *     1 2 3 4 5 6 7 8 9 10
         *   1
         *   2
         *   5
         * （2）子结构定义：要凑j得钱分为两步：
         * 第一步是只用 dp[i-1][j]的钱，节省空间就是旧dp[j]
         * 第二步是用当前金币c来凑，那么金币c如果得出金额j，那么只要凑到dp[j-c]加上金币c就能凑到j，那么怎么凑到j-c，其实就是dp[j-c-c]然后一直到最小为止
         *
         * （3）为什么dp[0]=1
         * 比如dp[5]怎么从金额5凑成5，那一定是dp[0]凑一个金币5所得，dp[0]=1
         *
         */
        int[] dp = new int[amount + 1];
        //因为默认有amount有值的时候是要+dp[0]的，dp[1]=dp[1]+dp[0]
        dp[0] = 1;
        for (int c : coins) {
            for (int j = 1; j <= amount; j++) {
                //可以看成爬楼梯，for(c:coins) 其实就是  dp[j] = dp[i-1]+dp[i-2]+dp[i-5];
                if (c > j) {
                    continue;
                }
                dp[j] += dp[j - c];
            }
        }

        return dp[amount];
    }

    public int change2(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 1; j <= amount; j++) {
            for (int coin : coins) {
                if (j < coin) {
                    continue;
                }
                dp[j] += dp[j - coin];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];

    }
}
