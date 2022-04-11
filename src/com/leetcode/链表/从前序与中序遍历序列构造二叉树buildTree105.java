package com.leetcode.链表;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树buildTree105 {


    /**
     * 从前序与中序遍历序列构造二叉树
     *
     */


    int[] preorder = null;

    int[] inorder = null;

    Map<Integer,Integer> map = new HashMap<>();

    int k=-1;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // TODO: 2022/4/5
        //  preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        /**
         * 前序遍历和中序遍历构造二叉树
         * 根左右  ， 左根右
         * 可以把前序遍历堪称一个个根节点
         * 在中序遍历找到区间，怎么找到区间？
         */
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        this.preorder = preorder;
        this.inorder = inorder;

        return buildTree(0,preorder.length-1);
    }


    /**
     *
     */
    public TreeNode buildTree(int left,int right){
        if(left > right){
            return null;
        }

        int val = preorder[++k];
        TreeNode root = new TreeNode(val);

        int p = map.get(val);

        root.left = buildTree(left,p-1);

        root.right = buildTree(p+1,right);

        return root;
    }

}
