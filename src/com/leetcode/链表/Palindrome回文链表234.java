package com.leetcode.链表;

public class Palindrome回文链表234 {



    public boolean isPalindrome(ListNode head) {
        if (head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode start2 = null;
        ListNode end1 =slow;
        if (fast.next != null){
            //奇数
            start2 = slow.next.next;
        }else {
            start2 = slow.next;
        }
        end1.next= null;
        ListNode newHead = reverseList(head);

        while(newHead != null){
            if (newHead.val != start2.val){
                return false;
            }else {
                newHead = newHead.next;
                start2 = start2.next;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode p = head;
        while(p!= null){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return prev;
    }


}
