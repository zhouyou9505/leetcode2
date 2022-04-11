package com.leetcode.动态规划;

import java.util.Stack;

public class LongestValidParentheses32 {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses32().longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<>();
       stack.push(-1);
       int max = 0;
       for(int i=0;i<s.length();i++){
           if(s.charAt(i) == '('){
               stack.push(i);
           }else{
               stack.pop();
               if(stack.isEmpty()){
                   stack.push(i);
               }
               max = Math.max(max,i - stack.peek());
           }
       }
       return max;
    }

    public int longestValidParenthesesDp(String s) {
        /**
         *  动态规划：
         *  1.用一个dp维护字串的最大值
         *  2.碰到 ( ，碰到 ) 就统计，
         *  如果是 i-1是 '(' 就dp[i-2]+2
         *  否则-如果是大括号 ，对称的是 '(' 。
         *       dp[i] = dp[i-1] + 2;
         *       如果左边还有相邻的 那就再加上 dp[i-dp[i-1]-2]
         */
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                //小括号
                if (s.charAt(i - 1) == '(') {
                    if (i == 1) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                    //是否是大括号
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //括号里面的子括号dp
                    dp[i] = dp[i - 1] + 2;

                    //括号左边的相邻dp
                    if (i - dp[i - 1] - 2 > 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }


    /**
     * 暴力解法：
     * 1.通过滑动窗口，来判断窗口内的括号是否是有效括号。
     * 2.首先确认len是最大的偶数，然后每次-2 复杂度 O N^3
     */
    public int longestValidParenthesesForce(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int len = s.length();
        int iStart = len % 2 == 0 ? len : len - 1;
        for (int i = iStart; i >= 2; i--) {
            for (int j = 0; j < len - i + 1; j++) {
                if (isValid(s.substring(j, j + i))) {
                    return i;
                }
            }
        }
        return 0;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
