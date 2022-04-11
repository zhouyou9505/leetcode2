package com.leetcode.二叉树;

import com.leetcode.TreeNode;

public class IsValidBST98 {


    /**
     * 本体思路：
     * 1、左边的所有节点一定比 root.val小
     * 2、右边的所有节点一定比 root.val大
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    boolean isValid(TreeNode root,long low,long high){

        if(root == null){
            return true;
        }

        if(root.val <= low || root.val >= high){
            return false;
        }


        return isValid(root.left,low,root.val) && isValid(root.right,root.val,high);
    }






    /**
     *
     只是判断根节点大于左右节点 ， 这个case很难搞定  [5,1,6,null,null,3,7]
     本体思路：
     可以利用中序遍历是递增的特性， 左根右
     */
    boolean compare = true;

    long prev = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {

        dfs(root);

        return compare;
    }

    public boolean dfs(TreeNode root){

        if(root == null){
            return true;
        }
        if(!compare){
            return false;
        }

        dfs(root.left);

        //如果now 小于等于上一个节点，那compare肯定失败
        if(root.val <= prev){
            compare = false;
        }

        prev = root.val;

        dfs(root.right);

        return true;
    }
}
