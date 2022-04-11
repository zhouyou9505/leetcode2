package com.leetcode.动态规划;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 */
public class Trap42 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap42().trap(nums));
    }

    /**
     * 思考三部曲：
     * 1、暴力搜索怎么做？是否有重复计算？重复计算了什么
     * 接雨水：遍历每个值，然后求这个值左边的柱子的最大值，和右边柱子的最大值，然后看较小柱子，是否比自身height[i]高，就能积水
     * 重复计算：每个下标都要计算左右区间的最大值.
     *
     * 2、第一次思考怎么做
     * 如果能用两个dp直接把左区间最大值，和右区间最大值保存下来，下次直接使用就可以了，可以把O(n^2)降级到O(N)
     *
     * 3、动态规划最优解
     * 和第一次思考完全符合
     *
     * 4、中间有什么关联
     * 暴力搜索 -> 第一次思考：还是比较简单的，每次都要求左右柱子的左边最大，和右边最大。
     * 第一次思考 -> 动态规划： 简单
     */
    public int trap(int[] height) {
        //遍历每个元素。等于左右两边的高度值的较小值，减去当前的高度
        int len = height.length;
        int res = 0;
        //i左边的最大值
        int[] leftDp = new int[len];
        //i右边的最大值
        int[] rightDp = new int[len];

        leftDp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftDp[i] = Math.max(height[i - 1], leftDp[i - 1]);
        }

        rightDp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            rightDp[i] = Math.max(height[i + 1], rightDp[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            int min = Math.min(leftDp[i], rightDp[i]);
            res += Math.max(0, min - height[i]);
        }

        return res;
    }


    /**
     * 暴力解法
     */
    public int trap2(int[] height) {
        //遍历每个元素。等于左右两边的高度值的较小值，减去当前的高度
        int len = height.length;
        int res = 0;

        for (int i = 0; i < len; i++) {

            int maxLeft = 0;
            for (int left = 0; left < i; left++) {
                maxLeft = Math.max(maxLeft, height[left]);
            }
            int maxRight = 0;
            for (int right = i + 1; right < len; right++) {
                maxRight = Math.max(maxRight, height[right]);
            }

            int min = Math.min(maxLeft, maxRight);
            res += Math.max(0, min - height[i]);
        }

        return res;
    }
}
