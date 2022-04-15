package com.leetcode.二叉树;

import com.leetcode.TreeNode;

public class HasPathSum路径总和112 {


    boolean status = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {

        dfs(root,0,targetSum);
        return status;
    }

    public void dfs(TreeNode root,int now,int targetSum){
        if (root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if (now+root.val == targetSum){
                status = true;
            }
        }
        dfs(root.left,now,targetSum);
        dfs(root.right,now,targetSum);
    }
}
