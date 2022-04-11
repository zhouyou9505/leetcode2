package com.leetcode.二叉树;

import com.leetcode.TreeNode;

import java.util.*;

public class ZigzagLevelOrder103 {


    /**
     * 本体思路：
     * 1.用广度优先遍历。
     * 2.用level%2 来判断当前的层级奇偶
     * 3.两个队列
     * node queue一直都是从左到右的offer node.
     * val deque 如果当前是偶数层，那上一层poll出来的奇数层的node，就offerLast，奇数层就是从左往右
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null){
            queue.offer(root);
        }
        int level = 1;
        while(!queue.isEmpty()){
            ++level;
            Deque<Integer> valDeque = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curNode = queue.poll();
                if(level%2 == 0){
                    //当前是偶数层，上一层就是奇数层，奇数就是从左往右
                    valDeque.addLast(curNode.val);
                }else {
                    valDeque.addFirst(curNode.val);
                }

                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
            }

            res.add(new ArrayList<>(valDeque));


        }

        return res;
    }

}
