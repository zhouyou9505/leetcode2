package com.leetcode.动态规划;

import java.util.*;

/**
 * 复原ip地址
 */
public class RestoreIpAddresses {

    /**
     * 本题思路：
     * 1.长度小于4，大于12 肯定是不行的
     * 2.通过dfs遍历可能的情况
     *  2.1 （剪枝）通过 s.length()-i 和 剩余的段*3 进行比较。如果s.length()-i大于它说明i加的不够多，就continue一下
     *  2.2 然后判断取出来的 s.substring(start,i+1) 是否符合条件
     *  2.3 用deque存tmpStr
     *  2.4 如果residue==0   start=len 就用res.add(String.join(".",deque)) 否则return
     *
     * 判断tmpStr是否符合条件
     * 如果 i+1-start>1，并且s.charAt(start)==0，说明是083，返回false
     * 如果  0<=Integer.parseInt(tmpStr)<=255 返回true否则false
     * @param args
     */
    public static void main(String[] args) {
        new RestoreIpAddresses().restoreIpAddresses("25525511135");
    }


    List<String> res = new ArrayList<>();

    Deque<String> deque = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {

        //判断
        if (s.length() > 12 || s.length() < 4) {
            return res;
        }

        int start = 0;
        int residue = 4;
        dfs(s, start, residue);

        return res;
    }

    public void dfs(String s, int start, int residue) {


        //剩余的段为0，并且start到length了
        if (residue == 0) {
            if (start == s.length()){
                res.add(String.join(".", deque));
            }
            return;
        }


        for (int i = start; i < start + 3 && i <s.length(); i++) {

            //剪枝
            if (s.length() - (i+1) > (residue-1)* 3) {
                continue;
            }

            if(!validate(s,start,i+1)){
                continue;
            }

            deque.addLast(s.substring(start,i+1));

            dfs(s,i+1,residue-1);

            deque.removeLast();

        }

    }

    public boolean validate(String s,int start,int end){

        //如果end-start > 1 并且s==0，是不行的
        if(end - start > 1 && s.charAt(start) == '0'){
            return false;
        }

        int tmp = Integer.parseInt(s.substring(start,end));

        return tmp >=0 && tmp <=255;
    }
}
