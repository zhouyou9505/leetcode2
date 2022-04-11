package com.leetcode.递归;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 全排列Permute46 {


    List<List<Integer>> result = new ArrayList<>();
    boolean[] used =null;

    public List<List<Integer>> permute(int[] nums) {

        used = new boolean[nums.length];

        Deque<Integer> deque = new LinkedList<>();
        dfs(nums,deque);
        return result;
    }


    public void dfs(int[] nums,Deque<Integer> deque){
        if(deque.size() == nums.length){
            result.add(new ArrayList<>(deque));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            deque.addLast(i);
            dfs(nums,deque);
            used[i] = false;
            deque.removeLast();
        }
    }
}
