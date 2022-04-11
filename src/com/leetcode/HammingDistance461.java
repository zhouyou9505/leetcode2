package com.leetcode;

public class HammingDistance461 {

    public int hammingDistance(int x, int y) {

        //异或 如果是xy的二进制上是不同的就是1，相同的就是0
        int c = x ^ y;

        int count = 0;
        while(c>0){
            int mod = c % 2;
            if(mod == 1){
                ++count;
            }
            c = c / 2;
        }

        return count;
    }
}
