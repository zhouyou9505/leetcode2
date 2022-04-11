package com.leetcode.链表;

public class ReverseList206 {

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * 1 -> 3 -> 4 -> 5
     *
     * 先定义一个 prev=null,  再定义curr指针
     * while(curr != null){
     *     记录下下一个留给待会curr进1 ListNode next = curr.next;
     *     curr当前指向左边  curr.next = prev;
     *     左边进1 prev = curr;
     *     当前进1 curr = next;
     * }
     * 返回节点5
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
