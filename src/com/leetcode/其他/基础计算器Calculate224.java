package com.leetcode.其他;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 基础计算器Calculate224 {

    public static void main(String[] args) {
        System.out.println(new 基础计算器Calculate224().calculate(
                " 2-1 + 2 "));
    }

    /**
     * 本题的思路：
     * 通过 ++ 得 + ，-+得- ，+-得-，--得+ 来将括号拆开
     * 用一个sign来做标识，碰到 + 就是 sign=getLast()   sign=-getLast()，
     * （1）普通的+-也这样，因为后面跟着数字4，也一起加到result中
     * （2）括号前的+-也这样。
     * 然后就是碰到( 就压入到栈中，这样可以给后面这个 ( + - + ( 两个左括号的中间的符号带来影响，影响就是比如第一个+，不一定是真的+，是sign=getLast()，搞不好就变成-了
     */
    public int calculate(String s) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        int sign = 1;
        deque.addLast(sign);
        s = s.replaceAll(" ","");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '+') {
                sign = deque.getLast();
            } else if (s.charAt(i) == '-') {
                sign = -deque.getLast();
            } else if (s.charAt(i) == '(') {
                deque.addLast(sign);
            } else if (s.charAt(i) == ')') {
                deque.removeLast();
            } else {
                int tmp = 0;
                while (i < s.length() && (s.charAt(i)-'0') >= 0 && (s.charAt(i)-'0') <= 9) {
                    tmp = tmp*10 + (s.charAt(i)-'0');
                    ++i;
                }
                result += sign * tmp;
                if(i != s.length()-1){
                    --i;
                }

            }
        }
        return result;
    }

}
