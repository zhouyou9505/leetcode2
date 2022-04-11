package com.leetcode.链表;

public class 环形链表2142 {


    /**
     * 1.通过快慢指针看是否有环 ，这个快慢指针的出发点都是head, slow=head,fast=head
     * 2.再从head发起碰撞 , slow.next == slow2.next
     *
     * 证明：第二次相遇就是环的入口
     * a是head到入环的起点，c是快慢指针碰撞的带你
     * 慢指针距离 a+b
     * 快指针距离是 a+n周长+b
     * a+n(b+c)+b = 2*(a+b)
     * a = n(b+c)-b;
     * a = n(b+c-1)+c;
     * 把c逆时针看，a其实就是c绕了n圈之后，再走了c步
     * a          b
     * ------------|------------|
     *             |            |
     *             |            |
     *             |            |
     *            c|            |
     *             --------------
     *
     * 证明：快慢指针一定在第一次环内相遇
     * 步骤一：环的长度A，慢指针走了C,快指针在B处
     * C % A = (B + 2C+ n*A) % A  //这个是相遇公式
     * C+n*A = B+2C  //慢指针+C步 后经过n圈，和快指针B+2C相遇
     * C = n*A-B;
     * 如果n=1圈时，C在[0,A)中，所以一定能相遇
     *

     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        ListNode slow2 = head;
        while (slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }


    /**
     *
     * 设 环的长度为A,慢指针在入环的时候快指针在环中的位置B(取值范围0到A-1),
     * 当快慢指针相遇时 [慢指针在环中走了C] ,有
     *     C % A = ( B + 2C) % A,等价于
     *     An + C = B + 2C,合并得
     *     C = An - B
     *     当 n=1 时 , 0 <= C < A
     * 故 慢指针在第一圈必定能和快指针相遇
     *
     *
     * 解释：为何慢指针第一圈走不完一定会和快指针相遇： 首先，
     * 第一步，快指针先进入环
     * 第二步：当慢指针刚到达环的入口时，快指针此时在环中的某个位置(也可能此时相遇)
     * 第三步：设此时快指针和慢指针距离为x，若在第二步相遇，则x = 0；
     * 第四步：设环的周长为n，那么看成快指针追赶慢指针，需要追赶n-x；
     * 第五步：快指针每次都追赶慢指针1个单位，设慢指针速度1/s，快指针2/s，那么追赶需要(n-x)s
     * 第六步：在n-x秒内，慢指针走了n-x单位，因为x>=0，则慢指针走的路程小于等于n，即走不完一圈就和快指针相遇
     */

}
