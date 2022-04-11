package com.leetcode.二分查找;

public class SearchRange在排序数组中查找元素的第一个和最后一个位置34 {



    /**
     * 这是一个很经典的二分查找，找第一个符合条件的和最后一个符合条件的
     * 其实对应的二分法的两种写法
     */
    public int[] searchRange(int[] nums, int target) {

        //find the first index
        int left=0,right=nums.length;
        while(left < right){
            int mid = (left+right) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        if (nums[right] != target){
            return new int[]{-1,-1};
        }

        int start = right;

        //find the end index

        left = right;
        right = nums.length-1;
        while(left < right){
            int mid = (left + right + 1) / 2;  //todo 如果一直是(left+right)/2，会导致存在 这种case死循环 [1,2,3] 2
            if(nums[mid] <= target){
                left = mid;    //todo 不能是left=mid+1这样，会导致本来和mid相等的left，+1后比mid大了。
            }else {
                right = mid - 1;
            }
        }
        return new int[]{start,right};
    }


}
