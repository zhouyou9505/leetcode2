package com.leetcode.动态规划.子序列.子数组;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 */
public class MaxSubArray53 {

    /**
     * 一维数组
     * 如果dp[i-1]>=0 说明接下来的dp计算可以带上之前的
     */
    public int maxSubArray(int[] nums) {

        int len = nums.length;

        /**

         理解题意：
         连续子串

         确认使用动态规划：
         1.先确认是否有重复计算
         2.定义子问题（定义出的子问题能有关联性，后面的子问题包含前面子问题）：
         以i结尾的集合枚举中最大的子集和，因为集合是连续的，所以这个dp[i]一定是nums[i] 或者 nums[x]-num[i]

         3.
         然后遍历dp，求哪个dp[i]是最大的
         */

        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i=1;i<len;i++){
            if(dp[i-1] >= 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }

        int max= Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
