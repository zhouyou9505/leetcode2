package com.leetcode;

public class CountBit338 {

    public static void main(String[] args) {
        new CountBit338().countBits(2);
    }

    public int[] countBits(int n) {

        int[] result = new int[n+1];
        //int[] memo = new int[];

        for(int i = 1; i <= n; i++){
            if(i % 2 == 1){
                //奇数比偶数多一个
                result[i] = result[i-1] + 1;
            } else{
                //偶数和他的一半一样多
                result[i] = result[i/2];
            }
        }

        return result;
    }
}
