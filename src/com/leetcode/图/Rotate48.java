package com.leetcode.图;

public class Rotate48 {

    public void rotate(int[][] matrix) {
        //
        int len = matrix.length;
        //(len+1)/2可以保证偶数的结果是偶数的一半

        //旋转面积  i<(len+1)/2 , j<len/2
        for(int i=0;i<(len+1)/2;i++){

            for(int j=0;j<len/2;j++){

                int limit = matrix[i].length-1;

                int tmp = matrix[i][j];
                //
                matrix[i][j] = matrix[limit-j][i];
                //
                matrix[limit-j][i] = matrix[limit-i][limit-j];
                //
                matrix[limit-i][limit-j]= matrix[j][limit-i];
                //
                matrix[j][limit-i] = tmp;
            }
        }
    }


    /**
     * 旋转图像，然后每行做个翻转
     */
    public void rotate1(int[][] matrix) {
        //对角线
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //每行做个翻转
        for(int i=0;i<matrix.length;i++){
            int left = 0;
            int right = matrix[i].length-1;
            while(left < right){
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                ++left;
                --right;
            }
        }
    }
}
