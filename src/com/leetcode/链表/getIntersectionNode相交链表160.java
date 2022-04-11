package com.leetcode.链表;

public class getIntersectionNode相交链表160 {


    /**
     * 本题的思路：
     * 1、通过判断双指针行走过的节点是否存在相同节点，或者是 走过相同的长度后节点是否能相等
     * 2、双方交换行走路径后，不管是相交还是不相交，一定会相等，(1)真相等，（2）都等于null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
