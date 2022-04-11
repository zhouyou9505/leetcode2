package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后
 * ，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 *
 */
public class DailyTemperatures739 {

    public static void main(String[] args) {
        int[] teps = {73,74,75,71,69,72,76,73};
        new DailyTemperatures739().dailyTemperatures(teps);
    }


    public int[] dailyTemperatures(int[] temperatures) {


        //维护单调栈，如果右边的数字比栈顶元素大，那就pop出来
        int[] answers = new int[temperatures.length];

        Stack<String> stack = new Stack<String>();

        for(int t=0;t<temperatures.length;t++){
            if(!stack.isEmpty()){
                String top = stack.peek();
                int temp = Integer.valueOf(top.split("_")[0]);
                int ind = Integer.valueOf(top.split("_")[1]);
                if(temperatures[t] > temp){
                    stack.pop();
                    answers[ind] = t-ind;
                }
            }
            stack.push(temperatures[t]+"_"+t);
        }

        return answers;

    }
}
