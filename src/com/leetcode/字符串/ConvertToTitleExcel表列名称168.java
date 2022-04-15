package com.leetcode.字符串;

public class ConvertToTitleExcel表列名称168 {


    public String convertToTitle(int columnNumber) {

        String res = "";

        while(columnNumber > 0){
            --columnNumber;
            int i = columnNumber % 26;
            char str = (char)(i + 'A');
            res = res + str;
            columnNumber = columnNumber / 26;
        }

        return res;
    }
}
