package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    public static void main(String[] args) {
        LRUCache146 cache146 = new LRUCache146(3);
        cache146.put(1,-1);
        cache146.put(2,-2);
        cache146.put(3,-3);
        cache146.put(1,-1);
        cache146.put(4,-4);
        //应该是  4,1,3

    }


    /**
     * 本题的关键在于 怎么O(n)的复杂度找到 map并且更新，并且记录最近使用的记录，让最少使用的被逐出
     * map做O(n)查找，更新用双向链表也是O(n) 用来维护最新使用
     */

    int capacity = 0;
    public LRUNode start = new LRUNode(0, 0);
    public LRUNode end = new LRUNode(0, 0);
    public Map<Integer, LRUNode> map = new HashMap<>();


    public LRUCache146(int capacity) {
        this.capacity = capacity;
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        toHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        LRUNode node = null;
        if (map.get(key) != null) {
            node = map.get(key);
            node.val = value;
            map.put(key,node);
        } else {
            node = new LRUNode(key, value);
            clear();
            map.put(key,node);
        }
        toHead(node);
    }

    public void toHead(LRUNode lruNode) {
        if (lruNode != start.next) {
            if (lruNode.prev != null) {
                LRUNode tmp1 = lruNode.prev;
                LRUNode tmp2 = lruNode.next;
                tmp1.next = tmp2;
                tmp2.prev = tmp1;
            }
            LRUNode tmp = start.next;
            start.next = lruNode;
            lruNode.prev = start;

            lruNode.next = tmp;
            tmp.prev = lruNode;
        }
    }

    public void clear() {
        if (map.size() >= capacity) {
            LRUNode tmp = end.prev;
            LRUNode prev = tmp.prev;
            prev.next = end;
            end.prev = prev;
            map.remove(tmp.key);
        }
    }


    public class LRUNode {
        public int key;
        public int val;
        public LRUNode prev;
        public LRUNode next;

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
