package com.leetcode.二叉树;

import com.leetcode.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 */
public class DeleteNode450 {


    /**
     * 本题的关键在于，删除节点分三种情况
     * (1) 如果节点是叶子节点，那就直接把他删了
     * (2) 因为是二叉搜索树，如果节点有有子节点，找到右子树的最小值替换root，二叉搜索树就平衡了
     * (3) 如果没有右子树，如果是左子树，那找到左子树最大的替换root。
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }

        if (key < root.val){
            root.left = deleteNode(root.left,key);
        }else if (key > root.val){
            root.right = deleteNode(root.right,key);
        } else {
            if (root.left == null && root.right == null){
                return null;// 这个就是删除叶子节点
            }else if (root.right != null){
                root.val = findSmallest(root.right);
                //如果右边删光了，那就空了  //如果右边没删光，就返回之前的右子树的root
                root.right = deleteNode(root.right,root.val);
            }else {
                root.val = findLargest(root.left);
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }

    public int findSmallest(TreeNode root){
        int val = root.val;
        while(root != null){
            val = root.val;
            root = root.left;
        }
        return val;
    }

    public int findLargest(TreeNode root){
        int val = root.val;
        while(root != null){
            val = root.val;
            root = root.right;
        }
        return val;
    }




}
