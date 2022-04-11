package com.leetcode.动态规划.背包问题.完全背包;


import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 */
public class WordBreak139 {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaaa", "aaa");
        System.out.println(new WordBreak139().wordBreak(
                "aaaaaaa", list));
    }


    /**
     * 和 CoinChange332很像
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            //求组合数，通过各种组合形成applepenapple
            for (String word : wordDict) {
                if (i + word.length() <= s.length()) {
                    //滑动窗口，可以保证dp[i+wordLength]是正确的
                    String tmp = s.substring(i, i + word.length());
                    //dp[i]的目的是 防止 aaaaaaa aaa aaaa，但是在i移动到2过程种，aaaa出现dp[4]=dp[1]=false ，之前dp[4]由于dp[0]+aaaa已经是true
                    if (dp[i] && word.equals(tmp)) {
                        dp[i + word.length()] = dp[i];
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[s.length()];
    }

}
