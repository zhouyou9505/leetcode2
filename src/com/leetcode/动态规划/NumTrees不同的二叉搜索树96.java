package com.leetcode.动态规划;

public class NumTrees不同的二叉搜索树96 {


    /**
     * 二叉搜索树有 G(3)
     * G(3)= f1 + f2 +f3  以1为根节点的搜索树，以2为根节点的搜索树，以3为根节点的搜索树
     * f1 = G(1-1)*G(3-1) = G0*G2 左子节点的组合数 * 右子节点的组合数 ，那其实就是要算出G(2)
     * f2 = G(2-1)*G(3-2) = G(1)*G(1)
     * f3 = G(3-1)*G(3-3) = G(2)*G(0)
     *
     * G(2)= f1 + f2    i-1 * n-i
     * f1 = G(1-1)*G(2-1) = G0 * G1
     * f2 = G(2-1)*G(2-2) = G1 * G0
     * 根据动态规划，把G看成dp，就是要先算 dp[0] dp[1] dp[2]，那就是就能算出dp[3]了
     */
    public int numTrees(int n) {

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            //i=2 就是G2
            for (int j = 1; j <= i; j++) {
                //为什么是+= 因为f1 + f2
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
