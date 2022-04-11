package com.leetcode.动态规划.子序列.子数组;

public class MaxProduct152 {

    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(new MaxProduct152().maxProduct(nums));
    }

    /**

     乘积最大的非空连续子数组

     */
    public int maxProduct(int[] nums) {

        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];

        //维护一个最大的dp和一个最小的dp，因为有符号谁知道最小的会不会变成最大，还有0因该怎么办？那么比较的时候加上max(nums[i])
        int max = nums[0];
        //dp表示到i为止，包括i的最大乘积
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for(int i = 1; i< nums.length; i++){

            //[3,-1,4]
            maxDP[i] = Math.max(Math.max(nums[i],maxDP[i-1]* nums[i]), minDP[i-1]*nums[i]);

            minDP[i] = Math.min(Math.min(nums[i],maxDP[i-1]* nums[i]), minDP[i-1]*nums[i]);

            max = Math.max(maxDP[i],max);
        }

        return max;
    }


    /**
     * 并不满足「最优子结构」
     */
    public int maxProduct2(int[] nums) {

        int length = nums.length;
        int[] maxDp = new int[length];
        int[] minDp = new int[length];
        System.arraycopy(nums, 0, maxDp, 0, length);
        System.arraycopy(nums, 0, minDp, 0, length);
        /**
         * 维护一个最大子数组乘积
         * maxDp[i] = Math.max(maxDp[i-1]*nums[i],nums[i])  但是最小子数组也可能产生比较大的值 maxDp[i] = max(maxDp[i-1]*nums[i],nums[i],minDp[i-1]*nums[i])
         * 维护一个最小子数组乘积
         */
        for (int i = 1; i < length; ++i) {

            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(nums[i], minDp[i - 1] * nums[i]));

            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));
        }
        int ans = maxDp[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxDp[i]);
        }
        return ans;

    }
}
