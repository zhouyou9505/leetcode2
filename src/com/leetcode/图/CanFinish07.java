package com.leetcode.图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本题的关键是：图中是否存在环，如果环了说明课程无法正常学习
 *
 */
public class CanFinish07 {


    public static void main(String[] args) {

        int[][] course = {{0,1}};
        new CanFinish07().canFinish(2,course);

    }


    boolean cycle = false;
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] studied = null;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        studied = new boolean[numCourses+1];

        //其实只要看有向图会不会产生环

        for(int[]  prer : prerequisites){
            List<Integer> list = map.getOrDefault(prer[1],new ArrayList<Integer>());
            list.add(prer[0]);
            map.put(prer[1],list);
        }

        for(int[] prer: prerequisites){
            boolean[] visit =  new boolean[numCourses+1];
            dfsCheck(prer[1],visit);
        }

        return !cycle;

    }

    public void dfsCheck(int now,boolean[] visit){

        if(visit[now]){
            cycle = true;
            return;
        }

        if(studied[now]){
            return;
        }

        List<Integer> list = map.get(now);
        if(list == null || list.isEmpty()){
            return;
        }

        for(Integer nextCourse : list){
            // FIXME: 2022/3/23 !!!还有这种操作 visit[now] 反正这点记得，挺特例的
            visit[now]= true;
            dfsCheck(nextCourse,visit);
            visit[now]= false;
        }

        //已经学习过了，基本上就是把now的下游全部遍历一遍
        studied[now] = true;
    }
}
