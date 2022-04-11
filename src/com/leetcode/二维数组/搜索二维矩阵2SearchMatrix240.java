package com.leetcode.二维数组;

public class 搜索二维矩阵2SearchMatrix240 {


    /**
     * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid2.jpg
     *
     * 该题的思路，就是要找一个递减的顺序，
     * 右往左下楼梯，就是一个递减的顺序
     * 如果已经最后一步楼梯还没找到，那就说明失败了
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                --j;
            } else if(target > matrix[i][j]){
                ++i;
            }
        }
        return false;
    }
}
