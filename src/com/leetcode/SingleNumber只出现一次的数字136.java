package com.leetcode;

import java.util.Arrays;

public class SingleNumber只出现一次的数字136 {


    public int singleNumber(int[] nums) {

        Arrays.sort(nums);

        for(int i = 0;i<nums.length-1; i=i+2){
            if (i == nums.length - 1){
                return nums[i];
            }
            if (nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(2^2);
    }
}
