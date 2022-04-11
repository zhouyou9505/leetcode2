package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays494 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        findTargetSumWays(nums, 3);
    }

    static Map<String, Integer> map = new HashMap<String, Integer>();

    public static int findTargetSumWays(int[] nums, int target) {

        return dfs(nums, 0, 0, target);

    }

    /**
     *
     */
    public static int dfs(int[] nums, int calCount, int calSum, int target) {

        if (calCount == nums.length) {
            return calSum == target ? 1 : 0;
        }

        if (map.get(calCount + "_" + calSum) != null) {

            return map.get(calCount + "_" + calSum);
        }


        int res = dfs(nums, calCount + 1, calSum + nums[calCount], target)
                + dfs(nums, calCount + 1, calSum - nums[calCount], target);

        map.put(calCount + "_" + calSum, res);

        return res;
    }


    public int findTargetSumWays2(int[] nums, int target) {

        int max = 0;
        for (int n : nums) {
            max += Math.abs(n);
        }
        //calculate sum nums max value
        //dp[][] store value
        //range is [-max,max]
        //equation : dp[i][j] = dp[i-1][j+nums[i-1]] + dp[i-1][j-nums[i-1]]
        int len = nums.length;

        int[][] dp = new int[len + 1][2 * max + 1];
        //dp[0][max] = 1; //=>其实就是 dp[0][0] dp的第二维都向右偏移了max  这个也可以
        dp[1][nums[0] + max] = 1;
        dp[1][-nums[0] + max] = 1;
        for (int i = 2; i <= len; i++) {
            int prev = nums[i - 1]; //i-1 means nums[i]
            for (int j = -max; j <= max; j++) {
                int newj = j + max;
                if (newj - prev >= 0) {
                    dp[i][newj] += dp[i - 1][newj - prev];
                }
                if (newj + prev <= 2 * max) {
                    dp[i][newj] += dp[i - 1][newj + prev];
                }
            }
        }
        return dp[len][target + max];
    }
}

