package com.leetcode.递归;

import java.util.*;

public class CombinationSum39 {


    int count = 0;

    Deque<Integer> deque = new LinkedList<Integer>();

    List<List<Integer>> result = new ArrayList<>();

    int[] memo = null;

    int target = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        Arrays.sort(candidates);

        memo = new int[target];

        this.target = target;

        dfs(candidates,0,target);

        return result;
    }


    public void dfs(int[] candidates,int start,int amount){

        if(amount < 0){
            return ;
        }


        if(amount == 0){
            result.add(new ArrayList<Integer>(deque));
            return ;
        }


        for(int i= start;i<candidates.length;i++){
            deque.addLast(candidates[i]);
            dfs(candidates,i,amount - candidates[i]);
            deque.removeLast();
        }


    }

}
