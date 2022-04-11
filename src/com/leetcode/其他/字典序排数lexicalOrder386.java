package com.leetcode.其他;

import java.util.ArrayList;
import java.util.List;

public class 字典序排数lexicalOrder386 {

    public static void main(String[] args) {
        new 字典序排数lexicalOrder386().lexicalOrder(109);
    }

    /**
     * 利用dfs特性
     *              169
     *            |
     *          |
     *        |
     *       1
     *     | | |
     *    10 11    12
     *  101 110(base:110=11*10)
     *
     */
    List<Integer> result = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        dfs(0,1,n);
        return result;
    }

    public void dfs(int base, int start, int n) {
        for (int i = start; i < 10; i++) {
            int m = base + i;
            if (m <= n) {
                result.add(m);
                /**
                 * 下一层级：一定是m打头，乘上10、100、...
                 * start 肯定是从0开始
                 */
                dfs(m * 10,0,n);
            }
        }
    }

}
