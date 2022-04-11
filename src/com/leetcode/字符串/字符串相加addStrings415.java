package com.leetcode.字符串;

public class 字符串相加addStrings415 {

    public static void main(String[] args) {
        new 字符串相加addStrings415().addStrings("0","9");
    }

    public String addStrings(String num1, String num2) {
        //以merge的方式叠加 , 考虑进1
        String str = "";
        int k = 0;

        int prev = 0;
        while(k < num1.length() || k < num2.length() || prev == 1){
            int a = k >= num1.length() ? 0 : num1.charAt(num1.length() - k - 1)-'0';
            int b = k >= num2.length() ? 0 : num2.charAt(num2.length() - k - 1)-'0';
            if(a + b +prev <= 9){
                str = (a+b+prev) + str;
                prev = 0;
            }else{
                str = (a+b+prev)%10 + str;
                prev = 1;
            }
            ++k;
        }

        return str;
    }
}
