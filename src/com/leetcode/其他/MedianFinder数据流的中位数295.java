package com.leetcode.其他;

import java.util.PriorityQueue;

public class MedianFinder数据流的中位数295 {

    class MedianFinder {


        PriorityQueue<Integer> minQue;
        PriorityQueue<Integer> maxQue;

        /**
         * 小顶堆里面存较大的元素，然后以小顶堆构造
         * 大顶堆里面存较小的元素，然后以大顶堆构造
         * 小顶堆数量大于等于大顶堆并且数据只差不超过1
         * if小顶堆数量大1：小顶堆的peek()
         * else数量相等：小顶堆peek()+大顶堆的peek() / 2
         */
        public MedianFinder() {
            minQue = new PriorityQueue<>((o1, o2) -> o1 - o2); //小顶堆
            maxQue = new PriorityQueue<>((o1, o2) -> o2 - o1); //大顶堆
        }

        /**
         * 如果这个大数小顶堆，num >= minQue.peek() , 放到小顶堆中
         */
        public void addNum(int num) {
            if (minQue.isEmpty() || num >= minQue.peek()) {
                minQue.offer(num);
                if (minQue.size() > maxQue.size() + 1) {
                    maxQue.offer(minQue.poll());
                }
            } else {
                maxQue.offer(num);
                if (maxQue.size() > minQue.size()) {
                    minQue.offer(maxQue.poll());
                }
            }
        }

        public double findMedian() {
            if (minQue.size() > maxQue.size()) {
                return minQue.peek();
            }
            return (minQue.peek() + maxQue.peek()) / 2.0;
        }
    }

}
