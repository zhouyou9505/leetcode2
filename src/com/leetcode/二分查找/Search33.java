package com.leetcode.二分查找;

public class Search33 {

    public int search(int[] nums, int target) {

        //题目意思：两段式数组局部升序排列的，怎么最快找到target   4567012
        //肯定不能On排序
        /**
         * mid = (left+right+1)/2;
         * 如果 nums[left] < nums[mid] 说明左边有序，看target是否在这个区间内，
         * 如果在，说明在 [left,mid] 中，看下 taget是否等于nums[mid] 不等于，说明是[left,mid-1]
         * 如果不在，一定在  [mid,right] 中，看下 taget是否等于nums[mid] 不等于，说明是[mid+1,right]
         */

        int left = 0 ;
        int right = nums.length-1;
        int mid = 0;
        // if left is sorted, compare mid to left/right , if not in right
        while(left <= right && mid < nums.length){
            mid = (left+right+1)/2;
            if(nums[left] < nums[mid]){
                if (target == nums[mid]){
                    return mid;
                }else if(target >= nums[left] && target <= nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (target == nums[mid]){
                    return mid;
                }else if(target >= nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

}
