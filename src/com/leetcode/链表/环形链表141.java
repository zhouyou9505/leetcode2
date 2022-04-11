package com.leetcode.链表;

public class 环形链表141 {


    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }


        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
