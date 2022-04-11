package com.leetcode.动态规划;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 */
public class LengthOfLIS300 {

    /**
     * 思考三部曲：
     * 1、暴力搜索怎么做？是否有重复计算？重复计算了什么
     * (1)每个数都去递归一遍，寻找最长子串，复杂度 2^n
     * (2)重复计算 1 3467，算到3 也是3467
     * 2、第一次思考怎么做
     * 这里看着如果能把dp[3]的后面的子串长度记下来，加上1就行了。
     * 3、动态规划最优解
     * 其实最优解是 dp[i]表示当前i最长的子串长度。
     * 把i前面的dp遍历一遍，看看nums[i]是否比nums[它]大，如果大说明dp[i] = dp[j]+1。这样我就不用重复跑一遍dp[j]的比较了
     * for(int i =1;i<len;i++){
     *     for(int j=0; j<i;j++){
     *         if(nums[i] > nums[j]){
     *            dp[i] = Math.max(dp[i],dp[j]);
     *          }
     *     }
     * }
     *
     * 4、中间有什么关联。
     * 暴力 -> 第一次思考：重复计算是对的，但是dp[]是用来记住前面的结论的
     * 第一次思考 -> 最优解：怎么把dp[i-1]赋值给dp[i]
     * （1）直接传过来是无法传播的，像这种没有连续的，就会出现dp[i]就可能是dp[i-2]+1的解得
     * （2）所以每一个dp[i]都把 dp[0-i]遍历一遍，求得dp[i]一定是这些子串里面最长的
     *
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,1);
        for(int i = 1;i<nums.length;i++){
            for(int j= 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i=0;i<=nums.length;i++){
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
