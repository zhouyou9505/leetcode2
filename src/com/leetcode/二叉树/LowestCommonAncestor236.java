package com.leetcode.二叉树;

import com.leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

public class LowestCommonAncestor236 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.right = new TreeNode(1);
        System.out.println(new LowestCommonAncestor236().lowestCommonAncestor(t, t.left, t.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //dfs动态规划
        if (root == null) {
            return null;
        }

        //最基本的判断， 如果root自身等于p
        if (root == p || root == q) {
            return root;
        }

        //看left,right是否能找到p,q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果在root左右同时找了pq，说明root一定是最近根节点。
        if (left != null && right != null) {
            return root;
        }
        //如果在root只找到了一个，那就说明root不是根节点，再root往上，先把p/q带上去
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        //如果啥都没找到，那就这个root肯定啥都不是
        return null;
    }


}
