package com.leetcode.动态规划;

public class FindLength718 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        new FindLength718().findLength(nums1, nums2);
    }

    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        //本来就是复用 dp[i-1] ，dp[i]
        int[] dp = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    if (j==0){
                        dp[j] = 1;
                    }else {
                        dp[j] = dp[j - 1] + 1;
                    }
                }else{
                    dp[j] = 0;
                }
                max = Math.max(dp[j], max);
            }
        }
        return max;
    }

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLengthV2(int[] nums1, int[] nums2) {

        int max = 0;
        //i,j处最长得子数组
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] != nums2[j]) {
                    dp[i][j] = 0;
                } else {
                    if (i >= 1 && j >= 1) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                max = Math.max(max, dp[i][nums2.length - 1]);
            }
        }
        return max;
    }
}
