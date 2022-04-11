package com.leetcode.字符串;

import netscape.security.UserTarget;

import java.util.Stack;

public class 有效的括号IsValid20 {


    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {

        //如果不是对称的就压进去，如果是对称就pop出来
        for(int i = 0;i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else {
                if(s.charAt(i) == ')' && stack.peek() == '('){
                    stack.pop();
                }else if(s.charAt(i) == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(s.charAt(i) == '}' && stack.peek() == '{'){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
