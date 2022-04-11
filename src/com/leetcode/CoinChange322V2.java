package com.leetcode;

import java.util.Arrays;

public class CoinChange322V2 {


    public static void main(String[] args) {
        int[] arr = {1,2,5,6};
        new CoinChange322V2().coinChange(arr,18);
    }

    int[] memo;

    public int coinChange(int[] coins, int amount) {

        memo = new int[amount+1];
        Arrays.fill(memo,0);

        //1.sort coins
        Arrays.sort(coins);

        //2.dfs combine case
        return dfs(coins,amount);

        //3.memo record case
    }


    public int dfs(int[] coins,int remind){

        if(remind < 0){
            return -1;
        }

        if(remind == 0){
            return 0;
        }

        if(memo[remind] != 0){
            return memo[remind];
        }

        //记录最少的次数
        int min = Integer.MAX_VALUE;
        for(int i=coins.length-1;i>=0;i--){
            int res = dfs(coins,remind-coins[i]);
            //为什么要 res<min ？ min=33,res=33,dfs(198)=dfs(196) ? 为什么出现这种情况？
            //min时指dfs(5)的次数，如果res返回的次数比min小，res有可能是dfs(3)的次数，那必须得比dfs(5)小，这样我才能保证每次次数是减少的
            //还有可能次数是增多的？ dfs(3)的组合场真的有可能比dfs(5)的组合次数多，比如 coins[1,5] , remain=5，
            if(res >= 0 && res < min){
                //算了一次res，相当于一次硬币兑换
                min = res + 1;
            }
        }

        // min==MAX_VALUE就是没有存储成功
        if(min != Integer.MAX_VALUE){
            memo[remind] = min;
        }
        //为什么打印是
        //不能
        return memo[remind];
    }

}
