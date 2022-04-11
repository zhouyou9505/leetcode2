package com.leetcode.回溯;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.util.*;

public class solveNQueensN皇后 {


    /**
     * 本题思路：
     * 1、同一行同一列，这个好判断 used[column]来判断
     * 2、同一对角线, set.add(row-nowColumn) , set.add(row+nowColumn);  如果在同一个对角线，产生的 差值/和 是相同的
     */

    public static void main(String[] args) {
        new solveNQueensN皇后().solveNQueens(4);
    }

    Set<Integer> d1 = new HashSet<>();
    Set<Integer> d2 = new HashSet<>();
    boolean[] used;
    int[] queens;

    List<List<String>> result = new ArrayList<>();
    int n = 0;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return result;
        }
        used = new boolean[n];
        this.n = n;
        queens = new int[n + 1];
        backtrack(0);
        return result;
    }


    public void backtrack(int row) {
        if (row > n) {
            return;
        }
        if (row == n) {
            buildBoard();
            return;
        }

        for (int column = 0; column < n; column++) {
            if (used[column]
                    || d1.contains(row - column)
                    || d2.contains(row + column)) {
                continue;
            }

            used[column] = true;
            d1.add(row - column);
            d2.add(row +  column);
            queens[row] = column;

            backtrack(row + 1);

            queens[row] = 0;
            used[column] = false;
            d1.remove(row - column);
            d2.remove(row + column);
        }
    }


    public void buildBoard() {
        List<String> list = new ArrayList<>();
        for(int i = 0;i < n ;i++){
            char[] tmpArr = new char[n];
            Arrays.fill(tmpArr,'.');
            tmpArr[queens[i]] = 'Q';
            list.add(String.valueOf(tmpArr));
        }
        result.add(list);
    }
}
