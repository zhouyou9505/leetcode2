package com.leetcode.数组;

public class 轮转数组rotate189 {


    /**
     * 空间复杂度为 O(1) 的 原地修改
     * <p>
     * 空间复杂度为O(1)是常量吗？
     */
    public void rotate(int[] nums, int k) {
        int[] memo = new int[nums.length];   // TODO: 2022/4/5 空间复杂度 O(n)
        for(int i=0;i<nums.length;i++){
            memo[i] = nums[i];
        }
        k = k%nums.length; // nums.length是一个轮回
        for (int i = 0; i < nums.length ; i++) {
            if(i - k < 0){
                nums[i] = memo[nums.length + i-k];
            }else {
                nums[i] = memo[i-k];
            }
        }
    }


    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
