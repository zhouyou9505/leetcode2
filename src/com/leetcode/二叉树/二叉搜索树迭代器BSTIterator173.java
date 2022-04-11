package com.leetcode.二叉树;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉搜索树迭代器BSTIterator173 {


    /**
     * 递归法，预先存下所有的treenode
     */
    class BSTIterator{

        int p = 0;

        List<TreeNode> list = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            //找到最左边的
            inorder(root);
        }

        public void inorder(TreeNode root){
            if(root == null){
                return;
            }
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }

        public int next() {
            if (p == list.size()){
                return -1;
            }
            int v =  list.get(p).val;
            p++;
            return v;
        }

        public boolean hasNext() {
            return p < list.size();
        }
    }

    /**
     * 迭代法，偏实时，但是也要在deque预先存好这个左子树，然后把curr一道right，方便存right的左子树
     */
    class BSTIterator2{

        TreeNode curr;

        Deque<TreeNode> deque = new LinkedList<>();

        public BSTIterator2(TreeNode root) {
            this.curr = root;
        }

        public int next() {
            while(curr != null){
                deque.addFirst(curr);
                curr = curr.left;
            }
            TreeNode first = deque.removeFirst();
            int res = first.val;
            curr = first.right;
            return res;
        }

        public boolean hasNext() {
            return curr != null || !deque.isEmpty();
        }
    }

}
