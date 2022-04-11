package com.leetcode.其他;

import java.util.Arrays;

public class 缺失的第一个正数FirstMissingPositive41 {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(new 缺失的第一个正数FirstMissingPositive41().firstMissingPositive(nums));
    }


    /**
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;
        /**
         * 第一步，先把nums中的无关紧要的负数排除掉
         */
        for (int i = 0; i < nums.length; ++i) {
            //为什么是小于等于0，因为0不算正数，把0放着会？？？
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        System.out.println(Arrays.toString(nums));


        /**
         * 第二步，原地hash，把value=x的值视为下标x，找到对应的nums[x]并且把它设置负数,这样，如果该数是负数，那对应x其实就是存在的
         * 比如：[18,2,0]怎么记录3存在，那如果是[]那就把下标
         */
        for (int i = 0; i < nums.length; ++i) {
            int tmp = Math.abs(nums[i]);

            // todo: 2022/4/4 注意了 tmp一定是正数，然后转成下标要-1
            if (tmp <= len){
                nums[tmp-1] = -Math.abs(nums[tmp-1]);
            }
        }
        System.out.println(Arrays.toString(nums));


        /**
         * 第三步，遍历nums,找到对应nums[i]大于0的，说明该下标i对应的正数就不存在
         */
        for (int i = 0; i < nums.length; ++i) {
            if(nums[i] > 0){
                return i + 1; //下标对应的值
            }
        }
        System.out.println(Arrays.toString(nums));


        return len+1;
    }


}
