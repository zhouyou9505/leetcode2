package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {


    /**
     * 本题思路：
     * 先排序
     *
     * for(int i=0;i<nums.length;i++){
     *     这里也要去重
     *     num[i-1]==nums[i] 要continue;
     *
     *
     *     left = i+1;
     *     right = nums.length
     *
     *
     *     left，right开始左右移动，注意去重特别是存进res的时候
     *
     * }
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();


        Arrays.sort(nums);

        for(int i = 0;i < nums.length;i++){

            if(i >= 1 && nums[i] == nums[i-1]){
                continue;
            }


            int left= i+1;
            int right = nums.length-1;
            while(left < right){

                if(nums[i] + nums[left] + nums[right] == 0){

                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left < right &&  nums[left] == nums[left+1]){
                        ++left;
                    }
                    ++left;

                    while(left < right && nums[right] == nums[right-1]){
                        --right;
                    }
                    --right;

                }else if(nums[i] + nums[left] + nums[right] < 0){
                    ++left;
                }else {
                    --right;
                }

            }
        }
        return res;
    }
}
