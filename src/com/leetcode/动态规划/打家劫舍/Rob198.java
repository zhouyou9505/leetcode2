package com.leetcode.动态规划.打家劫舍;

public class Rob198 {


    public static void main(String[] args) {


    }

    public int rob(int[] nums) {
        //dp表示第i步能获得的最多的钱
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1){
                dp[1] = Math.max(nums[0],nums[1]);
            }else{
                //偷东西，一定是隔1个，如果隔两个
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
        }
        return dp[nums.length-1];
    }


}
