package com.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicates删除排序链表中的重复元素83 {

    Map<Integer,Integer> map = new HashMap<>();

    public ListNode deleteDuplicates(ListNode head) {

        ListNode newHead = new ListNode();
        ListNode newP = newHead;
        ListNode p = head;

        while(p!= null){
            ListNode newN = new ListNode();
            int count = map.getOrDefault(p.val,0);
            if (count == 0){
                map.put(p.val,1);
                newN.val = p.val;
                newP.next = newN;
                newP = newP.next;
            }else {
                p = p.next;
            }
        }
        return newHead;
    }

}
