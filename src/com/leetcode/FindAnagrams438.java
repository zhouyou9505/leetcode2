package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams438 {

    public static void main(String[] args) {
        new FindAnagrams438().findAnagrams2("aa","bb");
    }

    public List<Integer> findAnagrams(String s, String p1) {

        //用subString来扣出子串，进行排序，然后和排序的p 进行equals

        //还可以用动态规划，判断哪一段不行
        char[] parr = p1.toCharArray();
        Arrays.sort(parr);

        int len = s.length();
        List<Integer> list = new ArrayList<Integer>();

        for(int left=0;left+parr.length <= len;++left){
            String sub = s.substring(left,left+parr.length);
            char[] subs = sub.toCharArray();
            Arrays.sort(subs);

            int count = 0;
            while(count < parr.length && subs[count] == parr[count]){
                ++count;
            }
            if (count != parr.length){
                continue;
            }

            list.add(left);
        }

        return list;
    }

    /**
     * 滑动窗口，用一维数组作填充来比较字符串是否相等
     * Arrays.equals()来比较两个数组是否相等
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {

        List<Integer> res = new ArrayList<Integer>();

        if (s.length() < p.length()){
            return res;
        }

        //滑动窗口 + array来判断

        int sLen = s.length();
        int pLen = p.length();

        int[] sDict = new int[26];
        int[] pDict = new int[26];

        /**
         * 先做一道初始化
         */
        for(int i=0;i<pLen;i++){
            ++sDict[s.charAt(i)-'a'];
            ++pDict[p.charAt(i)-'a'];
        }

        if(Arrays.equals(sDict,pDict)){
            res.add(0);
        }

        /**
         * 从0开始往右滑动
         */
        for(int i=0;i<sLen-pLen;i++){
            //开始往右滑动
            --sDict[s.charAt(i)-'a'];
            ++sDict[s.charAt(i+pLen)-'a'];
            if(Arrays.equals(sDict,pDict)){
                res.add(i+1);
            }
        }
        return res;
    }
}
