package com.leetcode.链表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyRandomList138 {


    /**
     * 先把 A-A', B->B' , C-> C' 存成map
     * 然后加入now是A： map.get(now).next = map.get(now.next); 其就是 A' -> B'
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {

        Map<Node,Node> map = new HashMap<>();
        Node headCopy = head;

        while(headCopy != null){
            Node newNode = new Node(headCopy.val);
            map.put(headCopy,newNode);
            headCopy = headCopy.next;
        }

        Node headCopy2 = head;

        while(headCopy2 !=null){
            //A' -> B'
            map.get(headCopy2).next= map.get(headCopy2.next);
            //A' -> C'
            map.get(headCopy2).random= map.get(headCopy2.random);

            headCopy2= headCopy2.next;
        }
        return map.get(head);
    }





    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
