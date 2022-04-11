package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers448 {

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println( findDisappearedNumbers(nums).toString());
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int count[]=new int[nums.length+1];
        List<Integer> ans=new ArrayList<>();
        for(int a:nums){
            count[a]++;
        }
        for(int i=1;i<=nums.length;i++){
            if(count[i]==0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {

        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }




}
