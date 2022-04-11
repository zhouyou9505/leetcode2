package com.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Merge56 {


    /**
     * 本题思路：
     * 1.先对数组的 第0位排序，然后大家在左区间上有序
     * 2.先塞入初始intervals[0]到Deque中，然后 removeLast()出来，一个个和intervals的区间比较，
     * 如果new[0]>old[1]说明进入新区间，不然就比较 new[1]和old[1]大小
     */
    public int[][] merge(int[][] intervals) {

        //进行排序，维护一个
        Deque<int[]> deque = new LinkedList<int[]>();

        Arrays.sort(intervals,(inte1, inte2) -> inte1[0]-inte2[0]);
        deque.addLast(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] arr = deque.removeLast();
            //four case
            int[] now = intervals[i];
            if(now[0]>arr[1]){
                deque.addLast(arr);
                deque.addLast(now);
            }else {
                int max = Math.max(arr[1],now[1]);
                deque.addLast(new int[]{arr[0],max});
            }
        }

        int k = 0;
        int[][] merged = new int[deque.size()][1];
        while(!deque.isEmpty()){
            merged[k] = deque.removeFirst();
            ++k;
        }
        return merged;
    }
}
