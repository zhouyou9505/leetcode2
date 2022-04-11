package com.leetcode.递归;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Shuffle384 {


    public static void main(String[] args) {

    }

    int[] init = null;
    int[] now;
    boolean[] used;

    public Shuffle384(int[] nums) {
        used = new boolean[nums.length];

        init = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            init[i] = nums[i];
        }
        now = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            now[i] = nums[i];
        }
    }

    void dfs(int[] nums, LinkedList<Integer> deque) {
        if (deque.size() > nums.length) {
            return;
        }
        if (deque.size() == nums.length) {
            for (int i= 0;i<deque.size();i++){
                now[i] = deque.get(i);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            deque.addLast(nums[i]);
            dfs(nums,deque);
            deque.removeLast();
            used[i] = false;
        }
    }

    public int[] reset() {
        return init;
    }

    public int[] shuffle() {
        LinkedList<Integer> deque = new LinkedList<Integer>();
        dfs(now, deque);
        return now;
    }
}
