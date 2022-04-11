package com.leetcode.二维数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinMeetingRooms会议室2_253 {


    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        //构造小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1,o2)->o1-o2
        );
        /**
         * 把结束时间压进小顶堆，这样后面的会议时间的开始时间和最快释放的会议室结束时间进行比较，如果能排在最快的时间后面，那说明能借用那个会议室
         * 如果连最快的会议室都有冲突，更别说另外那些很久才释放的会议室。
         * if借用成功：
         * else失败：
         * case：[4,7] [4,10] [8,9]
         */
        priorityQueue.offer(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            int now = intervals[i][0];
            if(now >= priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(intervals[i][1]);
            }else {
                priorityQueue.offer(intervals[i][1]);
            }
        }
        return priorityQueue.size();
    }


    public int minMeetingRooms暴力(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<List<int[]>> result = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        result.add(list);

        for (int i = 1; i < intervals.length; i++) {
            //和最后一个时间段，最后一个会议室的右边界比大小，如果比右边界大，就拼接，如果比右边界小就新增
            int which = -1;
            int[] arr = intervals[i];
            boolean processed = false;
            for (int j = 0; j < result.size(); j++) {
                List<int[]> item = result.get(j);
                int[] arrLast = item.get(item.size() - 1);
                if (arr[0] > arrLast[1]) {
                    item.add(arr);
                    processed = true;
                    break;
                }
            }
            if (!processed) {
                List<int[]> newArr = new ArrayList<>();
                newArr.add(arr);
                result.add(newArr);
            }
        }
        return result.size();

    }
}
