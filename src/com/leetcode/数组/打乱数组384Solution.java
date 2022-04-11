package com.leetcode.数组;

import java.util.*;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 * <p>
 * 实现 Solution class:
 * <p>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 */
public class 打乱数组384Solution {


    static class Solution {

        int[] original;

        public Solution(int[] nums) {
            original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {
            int[] now = new int[original.length];
            System.arraycopy(original, 0, now, 0, original.length);
            return now;
        }

        public int[] shuffle() {
            List<Integer> list = new ArrayList<>();
            for (int i : original) {
                list.add(i);
            }

            int[] now = new int[original.length];
            Random random = new Random();
            for (int i = 0; i < original.length; i++) {
                int size = list.size();
                now[i] = list.remove(random.nextInt(size));
            }
            return now;
        }
    }


}
