package com.leetcode.排序;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *  数组中的第K个最大元素
 */
public class FindKthLargest215 {


    public static void main(String[] args) {
        int[] nums= {2,3,1,1,5,5,2,2,4,4,2};
        System.out.println(new FindKthLargest215().findKthLargest(nums,5));
        System.out.println(new FindKthLargest215().findKthLargest2(nums,5));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n: nums){
            queue.offer(n);
            //如果大于k，那么肯定里面就剩5个最大的
            if (queue.size()>k){
                queue.poll();
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
