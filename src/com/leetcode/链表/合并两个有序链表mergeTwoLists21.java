package com.leetcode.链表;

public class 合并两个有序链表mergeTwoLists21 {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode prev = new ListNode();

        ListNode head2 = new ListNode();
        prev = head2;

        while (list1 != null && list2 != null) {

            ListNode tmp = new ListNode();
            if(list1.val < list2.val){
                tmp.val = list1.val;
                list1 = list1.next;
            }else {
                tmp.val = list2.val;
                list2 = list2.next;
            }
            head2.next = tmp;
            head2 = head2.next;
        }

        while(list1 != null){
            ListNode tmp = new ListNode();
            tmp.val = list1.val;

            head2.next = tmp;
            head2 = head2.next;

            list1 = list1.next;
        }
        while(list2 != null){
            ListNode tmp = new ListNode();
            tmp.val = list2.val;

            head2.next = tmp;
            head2 = head2.next;

            list2 = list2.next;
        }
        return prev.next;
    }
}
