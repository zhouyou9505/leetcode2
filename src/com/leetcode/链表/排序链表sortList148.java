package com.leetcode.链表;

public class 排序链表sortList148 {


    /**
     * 题目信息：
     *  O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
     *  归并的复杂度是：O(n log n)
     *  注意：是常数级空间复杂度 而不是 常量空间，其实就是O(n)的空间复杂度，其实就是空间最多能存n的节点
     *
     *
     * 使用归并排序
     * 1、使用快慢指针将链接拆分为两段
     *
     * 2、使用归并排序，将两个子链merge成一个
     * todo: 归并可不只是分成两个子链，是每个子链都分成两个子链，递归式的分割 。因为只把主链分成两段，这两段不是局部有序的
     */
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        return sort(head);
    }

    public ListNode sort(ListNode head){
        if(head == null || head.next == null){
            // TODO: 2022/4/5 注意了。这里是返回head
            return head;
        }
        //使用快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow现在就是分割点，把主链分成两段
        ListNode slowNext = slow.next;
        slow.next = null;

        ListNode start1 = sort(head);
        ListNode start2 = sort(slowNext);

        return mergeList(start1,start2);
    }

    public ListNode mergeList(ListNode start1,ListNode start2){
        ListNode p = new ListNode();
        ListNode prev = p;
        while(start1 != null && start2 != null){
            ListNode tmp = new ListNode();
            if(start1.val < start2.val){
                tmp.val = start1.val;
                start1 = start1.next;
            }else {
                tmp.val = start2.val;
                start2 = start2.next;
            }
            p.next = tmp;
            p = p.next;
        }

        while(start1 != null){
            p.next = new ListNode(start1.val);
            p = p.next;
            start1 = start1.next;
        }

        while(start2 != null){
            p.next = new ListNode(start2.val);
            p = p.next;
            start2 = start2.next;
        }
        return prev.next;
    }

}
