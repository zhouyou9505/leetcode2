package com.leetcode.排序;

import java.util.Random;

public class SortArray排序数组912_RandomizedQuickSort {

    static class RandomizedQuickSort {

        public static void main(String[] args) {
            int[] arr = new int[]{4, 1, 2, 9, 6, 3, 7};
            System.out.println(new RandomizedQuickSort().sortArray(arr));
        }

        /**
         * 快排
         */
        public int[] sortArray(int[] nums) {
            randomizedSortArray(nums,0,nums.length-1);
            return nums;
        }


        public void randomizedSortArray(int[] nums, int left, int right) {
            if (left < right){
                int pivot = partition(nums, left, right);
                randomizedSortArray(nums, left, pivot - 1);
                randomizedSortArray(nums, pivot + 1, right);
            }
        }

        private int partition(int[] nums, int left, int right) {
            int random = new Random().nextInt(right - left + 1) + left; // TODO: 知识点：如何如果要生成[3,4]  那就是[0,1]+3  那么next(2)+3
            swap(nums, random, right);

            int index = left;
            for (int i = left; i <= right - 1; i++) {
                if (nums[i] < nums[right]) {
                    swap(nums, i, index);
                    ++index;
                }
            }
            //把真正的中间值换过来，
            swap(nums,index,right);
            //返回下标
            return index;
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }


    }


}
