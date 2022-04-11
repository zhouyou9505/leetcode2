package com.leetcode.排序;

import java.util.Arrays;

public class QuickSort快排 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,9,6,3,7};
        System.out.println(new QuickSort快排().sort(arr));
    }

    public int[] sort(int[] sourceArray)  {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 将一个大数组，根据最左边的主元值，从下标1~右边界遍历，把小于主元的放左边，大于主元的放右边，然后逻辑分割一分为二
     * 再递归进行左子区间，右子区间按照刚才的方式移动，再化分成更小的。在划分的过程中，顺序就逐渐明朗了，最后每个子区间变成size=1或者size=2的。
     */
    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    /**
     * 通过比较当前i和pivot的值，index++来左引导把较小的i全部换到前面，
     * 然后再换一下pivot当前index-1的值，return这个index-1主元值
     */
    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
