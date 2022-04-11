package com.leetcode.递归;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {



    List<String> res = new ArrayList<String>();

    /**
     * 本体思路
     * 使用可重复塞值的递归
     * 定义左括号left，右括号right的数字，只要 left>=right即可
     *
     * dfs(left+1,right,str+"(")
     * dfs(left,right+1,str+")")
     */
    public List<String> generateParenthesis(int n) {

        int left= 0;
        int right = 0;
        dfs(left,right,"",n);
        return res;

    }


    public void dfs(int left,int right,String str,int n){


        if(str.length() == 2*n){
            res.add(str);
            return;
        }

        if(left < right){
            return;
        }

        if(left < n){
            dfs(left+1,right,str+"(",n);
        }

        if(right < n){
            dfs(left,right+1,str+")",n);
        }

    }
}
