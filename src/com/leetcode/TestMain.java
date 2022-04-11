package com.leetcode;

import java.util.*;

public class TestMain {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        findTargetSumWays(nums,3);
    }

   static Map<String,Integer> map = new HashMap<String,Integer>();

    public static int findTargetSumWays(int[] nums, int target) {

        return dfs(nums,0,0,target);

    }


    public static int dfs(int[] nums,int calCount,int calSum,int target){

        if(calCount == nums.length){
            return calSum == target ? 1 : 0;
        }

        if(map.get(calCount+"_"+calSum) != null){
            return map.get(calCount+"_"+calSum);
        }


        int res = dfs(nums,calCount+1,calSum+nums[calCount],target)
                + dfs(nums,calCount+1,calSum-nums[calCount],target);

        map.put(calCount+"_"+calSum,res);

        return res;
    }

}
