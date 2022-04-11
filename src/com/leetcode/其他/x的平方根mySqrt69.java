package com.leetcode.其他;

public class x的平方根mySqrt69 {


    /**
     * 本题的目的是求出
     * 如果平方等于x的 或者 平方接近与x的
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int res = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid * mid == x){
                return mid;
            }else if((long)mid * mid < x){
                // TODO: 2022/4/5 res取mid的而不要取+1的，是因为+1之后可能比right大，退出循环
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }


}
