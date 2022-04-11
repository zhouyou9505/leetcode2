package com.leetcode.二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的下一个结点NewCoder {


    Deque<TreeLinkNode> deque = new LinkedList<>();

    /**
     * 这道题的做法在于，把每个case都枚举一下
     * https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e?answerType=1&f=discussion
     * 注意的几个小点：
     * 1、如果节点A的右子树存在，那节点A的下一个节点是右子树最左边的
     * 2、（1）如果节点A自身是左子树，那其实就是A.next就是下一个节点，
     *    （2）如果节点B自身是右子树，那就网上找，直到找到往右转折的节点的next
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null){
            return null;
        }

        if (pNode.right != null){
           pNode = pNode.right;
           while(true){
               if (pNode.left == null){
                   return pNode;
               }
               pNode = pNode.left;
           }
        }else {
            while(pNode.next != null){
                if (pNode == pNode.next.left){
                    return pNode.next;
                }else {
                    pNode = pNode.next;
                }
            }
        }

        return null;
    }
}
