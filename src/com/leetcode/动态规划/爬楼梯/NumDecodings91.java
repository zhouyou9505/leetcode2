package com.leetcode.动态规划.爬楼梯;

public class NumDecodings91 {


    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }


        //dp表示在下标i，最多组合的次数
        int[] dp = new int[s.length()+1];

        /**
         i
         ----
         i-1 |
         -----
         i-2 |
         ------
         |

         爬楼梯问题：
         既可以从dp[i-1]过来，也可以从dp[i-2]过来
         从dp[i-1]过来的情况：
         （1）i == 0，对不起，过不来
         （2）i >0 ，可以 dp[i] = dp[i-1]

         从dp[i-2]过来的情况：
         （1）i-1 == 0，其实就是 int b=>[0,9]  对不起，过不来
         （2）i-1 在 int b 10~26中，可以从dp[i-2]过来
         （3）i-1 在 int b >26 对不起，过i不来

         */
        dp[0] = 1;
        dp[1] = 1;
        s = " "+s;
        for(int i = 2;i < s.length();i++){

            //123
            //如果i的位置是0，1、2是过不来的。
            //如果i的位置大于0，至少可以从2过来， 比如363
            int a = s.charAt(i) - '0';
            if(a > 0){
                dp[i] = dp[i-1];
            }

            int b = 10*(s.charAt(i-1) - '0') + s.charAt(i)-'0';
            if(b >= 10 && b <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()-1];
    }
}
