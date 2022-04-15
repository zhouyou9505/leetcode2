package com.leetcode;

import java.util.*;

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

    /**
     * 单调栈
     * 维护一个单调栈，这个单调栈用来计算一个数i ，最近一个比它大的数的间距。result[i]
     * 因为无法知道后面的情况，我可以用先把自身i存到栈中，然后等到后面的 temperature_j > temperature_i时，再来设置 result[i] = j-i 就是间距了，
     * 既然i处理完了旧把i pop掉，也不急着把j压进去，用while把栈里面的都试一遍，知道比大，就把j压进去
     */
    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        for(int i= 0;i<temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int peakIndex = stack.pop();
                result[peakIndex] = i-peakIndex;
            }
            stack.push(temperatures[i]);
        }
        return result;
    }
}
