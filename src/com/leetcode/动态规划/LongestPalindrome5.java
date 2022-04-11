package com.leetcode.动态规划;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
 */

/**
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
        System.out.println("a".substring(0,1));
    }

    /**
     * 动态规划
     * for遍历有边界，0~right
     *  for 从right-1 ~ 0
     *     如果 s.charAt(left)==s.charAt(right) && dp[left+1][right-1]==true，
     *
     *
     *
     *  比如 abxxxxba   我计算 a a是否是回文子串时，不用判断中间的数据，因为我在bb的时候已经计算过了bxxxxxb是回文子串
     *
     */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start= 0;
        int end= 0;
        for(int right=0;right < s.length(); right++){
            dp[right][right] = true;
            for(int left = right-1;left >=0 ;left--){
                if(s.charAt(left) == s.charAt(right) && (right-left == 1 || dp[left+1][right-1])){
                    dp[left][right] = true;
                    if(right-left > (end-start)){
                        start = left;
                        end = right;
                    }
                }

            }
        }
        return s.substring(start,end+1);
    }


    /**
     * 暴力解法
     * isPalindrome(s,i,i);
     * isPalindrome(s,i,i+1);
     */
    public String longestPalindrome2(String s) {

        if(s == null || s.length() < 1){
            return "";
        }

        int start = 0;
        int end = 0;
        int maxLen = 0;

        //找到中心点，向外扩展
        for(int i = 0;i<s.length();i++){

            int len1 = isPalindrome(s,i,i);
            int len2 = isPalindrome(s,i,i+1);

            int tmpLen = Math.max(len1,len2);

            if(tmpLen > maxLen){
                //len1 的半径是：tmpLen/2;  len2的话是 (tmpLen-1)/2
                start = i - (tmpLen-1)/2;
                end = i + tmpLen/2;
                maxLen = end-start+1;
            }
        }

        return s.substring(start,end+1);
    }

    public int isPalindrome(String s,int left,int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        return right-left-1;
    }
}
