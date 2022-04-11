package com.leetcode.二叉树;

import com.leetcode.TreeNode;

/**
 * 二叉树中的最大路径和
 * 注意就是自底向上反馈，如果该节点 或着 该子树(子树里面最大的路径)的和<=0，就放弃
 */
public class MaxPathSum124 {


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        System.out.println(new MaxPathSum124().maxPathSum(t));
    }


    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //dfs动态规划
        int dfs = dfsMax(root);
        max = Math.max(max, dfs);
        return max;
    }


    int dfsMax(TreeNode root) {

        //递归到叶子，看左右两边哪个大，返回大的，如果都小于0，则返回0
        if (root == null) {
            return 0;
        }
        //如果左子树路径返回
        int left = dfsMax(root.left);
        int right = dfsMax(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);

        //看自身子树路径的和max谁大
        max = Math.max(max, root.val + left + right);

        //返回给上面不能直接把子树总和返回给上面，只能返回单个路径，这个时候得把root.val返回上去，不要和0比较，因为 [-10]这样得树要返回给到最外层去感知，maxNode=-10
        return Math.max(root.val + left, root.val + right);
    }
}
