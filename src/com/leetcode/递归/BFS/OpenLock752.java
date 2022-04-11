package com.leetcode.递归.BFS;

import java.util.*;

public class OpenLock752 {


    /**
     * 1、为什么广度优先是最近的，因为递归深度是层层递进
     * 2、为什么要同时正反向，这样可以，因为轮子正着转和倒转的数据概率不一样
     */
    public int openLock(String[] deadends, String target) {

        Set<String> deadSet = new HashSet<>();
        for(String str : deadends){
            deadSet.add(str);
        }

        Set<String> processed = new HashSet<>();

        Deque<String> deque = new LinkedList<>();
        deque.addLast("0000");

        int step = 0;

        while(!deque.isEmpty()){

            int size = deque.size();

            for(int i= 0;i<size;i++){

                String last = deque.removeFirst();

                if(processed.contains(last) || deadSet.contains(last)){
                    continue;
                }

                //last
                if(target.equals(last)){
                    return step;
                }

                for(String tmp : bfs(last)){
                    deque.addLast(tmp);
                }
                processed.add(last);

            }
            ++step;

        }

        return -1;
    }

    public char turnUp(char c){
        return c == '9' ? '0' :(char)(c + 1);
    }

    public char turnDown(char c){
        return c == '0' ? '9' :(char)(c - 1);
    }

    public List<String> bfs(String last){
        List<String> list = new ArrayList<>();
        //last从0-3，上下各播一个，bfs
        char[] arr = last.toCharArray();
        for(int i = 0;i< last.length();i++){
            char c = arr[i];

            StringBuilder tmp = new StringBuilder(last);
            char a = turnUp(c);
            tmp.setCharAt(i,a);
            list.add(tmp.toString());

            StringBuilder tmp2 = new StringBuilder(last);
            char b = turnDown(c);
            tmp2.setCharAt(i,b);
            list.add(tmp2.toString());
        }
        return list;
    }

}
