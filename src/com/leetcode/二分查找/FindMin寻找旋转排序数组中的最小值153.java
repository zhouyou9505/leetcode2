package com.leetcode.二分查找;

public class FindMin寻找旋转排序数组中的最小值153 {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(new FindMin寻找旋转排序数组中的最小值153().findMin(nums));
    }

    /**
     * 一定那么复杂的判断，二分查找不一定要全局有序
     * https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
     *
     */
    public int findMin(int[] nums) {
        //find the min value by use binary find. then find the index

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            //如果nums[right]>nums[mid] 一定在[left,mid]中
            if (nums[mid] < nums[right]){
                right = mid;
            }else {
                //如果nums[mid] >= nums[right] ，那么最小值一定在mid右边
                //https://assets.leetcode-cn.com/solution-static/153/1.png  理解这个虚线，右区间的最大值一定小于左边的最小值
                left = mid+1;
            }
        }
        return nums[left];
    }
}
