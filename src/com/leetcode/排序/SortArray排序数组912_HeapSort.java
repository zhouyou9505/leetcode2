package com.leetcode.排序;

import java.util.Arrays;
import java.util.Random;

public class SortArray排序数组912_HeapSort {


    public static void main(String[] args) {
        int[] arr = new int[]{5,1,1,2,0,0};
        new SortArray排序数组912_HeapSort().heapSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{5,1,1,2,0,0};
        new SortArray排序数组912_HeapSort().headSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 堆排序分为两步：如果你想构造完全二叉树的顺序小顶堆
     * <p>
     * 第一步：创建初始堆，按照大顶堆的思路创建，从 arr.length-1/2 ~ 0 ,每到一个节点，就把它下面所有的节点构造成大顶堆，一定能把最大的值放到root节点
     * <p>
     * 第二步：把root和最后一个元素交换，把排序范围缩小一个，这样就可以把 最大值也就是刚才的root，给断开。
     * 然后继续构建 大顶堆（主要是把最大元素找到然后放到root），构建完后，重复第二步
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }


    private void headSort2(int[] nums) {
        //不能用+1 ，case： [0]
        for (int i = (nums.length -1 ) / 2; i >= 0; i--) {
            buildMaxHeapSort(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            // TODO: root 就是 0
            //每次-1 其实就是少排序一个元素
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;

            buildMaxHeapSort(nums, 0, i);
        }
    }

    /**
     * 构造大顶堆
     */
    public void buildMaxHeapSort(int[] nums, int parent, int length) {
        //看它是否有左右子节点
        int parentVal = nums[parent];

        int lChild = 2 * parent + 1;
        while (lChild < length) {

            if (lChild + 1 < length && nums[lChild + 1] > nums[lChild]) {
                lChild++;
            }

            if (parentVal >= nums[lChild]) {
                break;
            }
            //发现子节点比父节点大，就被这个子节点的值覆盖，并且把parent指向它
            nums[parent] = nums[lChild];
            parent = lChild;

            lChild = 2 * lChild + 1; //子节点也要指向新的左子节点，进行新一轮的比较
        }
        //最后这个parent一定指向了最适合的节点
        nums[parent] = parentVal;
    }

}
