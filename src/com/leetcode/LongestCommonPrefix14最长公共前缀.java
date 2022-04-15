package com.leetcode;

public class LongestCommonPrefix14最长公共前缀 {




    public String longestCommonPrefix(String[] strs) {

        int k = 0;

        for(int i = 0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j = 1;j< strs.length;j++){
                if (strs[j].charAt(i) != c){
                    k = i;
                    break;
                }
            }
        }

        return strs[0].substring(0,k);
    }

    public static void main(String[] args) {
        System.out.println("a".substring(0,0));
    }
}
