package com.leetcode.二叉树;

import com.leetcode.TreeNode;

public class InvertTree翻转二叉树226 {



    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return ;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        dfs(root.right);
        dfs(root.left);
    }

}
