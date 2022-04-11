package com.leetcode.动态规划;

public class NumDecodings91 {


    public static void main(String[] args) {
        System.out.println(new NumDecodings91().numDecodings("1241206"));
    }

    /**
     * 爬楼梯系列
     *
     * 如果当前不为0 ，那就dp[i] = dp[i-1]
     * 如果加上前面在 10~26 ，那就dp[i] = dp[i] + dp[i-2]
     * 1 2 0 6
     * dp[1] = dp[i-1] = 1;
     * dp[2] = {dp[i]=dp[i-1]=2 ; dp[i]满足10~26,dp[i]+=dp[i-2]}
     * dp[3] = {dp[i]=dp[i-2]=1; dp[i]只能平移dp[i-1]因为0破坏了前面的规则}
     * dp[4] = dp[i-1] 因为 s.charAt(i-1)在0~9中
     *
     *
     *
     *
     *
     *
     * 如果当前不为0 至少可以从平移过来 dp[i] = dp[i-1] 比如120，0和2组合了打破了12的两种组合  120=1
     * 如果等于0，只能考虑dp[i-2]。如果满足与 10~26，就dp[i] = dp[i] + dp[i-2]
     * 如果不等于0， 那就是 dp[i] = dp[i-1] + dp[dp-2]
     * 如果和前面组合
     * dp[i] += dp[i-2]
     * (1) 00 跳过，后面都完蛋
     * (2) 08 dp[i] = dp[i-1]
     * (4) 20 dp[i] = dp[i-2]
     * (5) 21 dp[i] = dp[i-1] + dp[i-2]
     * (6) 28 只能用上面的dp[i] = dp[i-1]
     * 综上所述：

     * 如果是 00 那么dp[i]=0
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (i > 1) {
                int sum = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                if (sum >= 10 && sum <= 26) {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[len];
    }


}
