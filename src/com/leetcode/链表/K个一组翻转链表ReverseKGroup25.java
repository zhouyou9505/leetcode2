package com.leetcode.链表;

import com.leetcode.TreeNode;

import java.util.List;

public class K个一组翻转链表ReverseKGroup25 {


    /**
     * 本题思路：
     * （1）挑选要反转的头和尾
     * （2）将头和尾反转 reverseList
     * （3）将prev移动到新的下标（挪动下标）
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode start = new ListNode();
        start.next = head;
        ListNode prev = start;

        //1.轮询到最后一个
        while(prev != null){

            ListNode tmpEnd = prev;
            for(int i=0;i<k;++i){
                tmpEnd = tmpEnd.next;
                if(tmpEnd == null){
                    return start.next;
                }
            }

            ListNode tmpEndNext = tmpEnd.next;
            //反转
            ListNode[] res = reverseList(prev.next,tmpEnd);

            //把子链拼接进主链
            prev.next = res[0];
            res[1].next = tmpEndNext;

            prev = res[1];
        }

        return start.next;
    }


    public ListNode[] reverseList(ListNode start,ListNode end){
        ListNode prev = end.next;
        ListNode start2 = start;
        while(prev != end){
            //先将nex保存下来，then start2=nex;
            ListNode nex = start2.next;
            start2.next = prev;
            //重新定义prev,start2 ,不能反
            prev = start2;
            start2 = nex;
        }
        return new ListNode[]{end,start};
    }

}
