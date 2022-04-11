package com.leetcode.图;

import java.util.ArrayList;
import java.util.List;

public class FindOrder210 {

    List<List<Integer>> matrix = new ArrayList<>();

    int k = 0;

    int[] learn = null;

    boolean cycle = false;

    int[] result = null;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            matrix.add(i, new ArrayList<Integer>());
        }

        for (int[] pre : prerequisites) {
            matrix.get(pre[1]).add(pre[0]);
        }

        this.k = numCourses - 1;
        learn = new int[numCourses];
        result = new int[numCourses];

        /**
         1.从0~course-1 轮询一遍，将多段有向路径，串成一个路径。
         为什么轮询course就能产生路径？ 是因为不用担心由于先轮询到
         这个courseA会造成其他的courseB由于courseA先学而造成环如果有[courseA,courseB]
         那么这个courseA肯定不会立马就存到res队列中，而是会在map.get(courseA)的时候把courseB取出并学习

         2.那为什么不自己主动去模拟下一个路径，这样可能造成本身没有环的，而出现环了

         3.如果出现环，说明有向图形成失败，课程选修失败
         */


        for (int n = 0; n < numCourses; n++) {
            //如果已经学习过了就不用再学习了
            dfs(n);
        }

        if (cycle) {
            return new int[0];
        }

        return result;

    }

    public void dfs(int nowCourse) {

        if (learn[nowCourse] == 2) {
            return;
        }

        if (k < 0) {
            return;
        }

        learn[nowCourse] = 1;

        List<Integer> nextList = matrix.get(nowCourse);

        for (int n : nextList) {
            if (learn[n] == 1) {
                cycle = true;
                return;
            }

            //learn[n] = 1; //不要把learn放在里面写，如果是入参是 2 []，这样根本就存不了learn[n]
            dfs(n);

        }

        learn[nowCourse] = 2;

        result[k--] = nowCourse;

    }

}
