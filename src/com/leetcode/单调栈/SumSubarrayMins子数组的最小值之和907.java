package com.leetcode.单调栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SumSubarrayMins子数组的最小值之和907 {


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1};
        new SumSubarrayMins子数组的最小值之和907().sumSubarrayMins(arr);
    }

    private static final int MOD = 1000000007;

    /**
     * 例如[3,1,2,4,1]、[3,1,2,4]、[3,1,2]、[1,2]等最小值都为1，我们把这叫做元素1的辐射范围
     */
    public int sumSubarrayMins(int[] arr) {
        // 处理边界情况
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        // 每个元素辐射范围的左边界
        int[] left = new int[n];
        // 每个元素辐射范围的右边界
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        // 第一次循环先找到所有元素的左边界
        for (int i = 0; i < n; i++) {
            // 向左找第一个小于等于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // 设立一个最左边界-1
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            stack.push(i);
        }

        // 第二次循环找到所有元素的右边界
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 向右找第一个小于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // 设立一个最右边界n
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            stack.push(i);
        }

        // 按照贡献度计算即可
        // 注意此处left[i]和right[i]实际上记录的是左边界-1和右边界+1，和上面思路中有些区别，便于计算
        long ans = 0;
        for (int i = 0; i < n; i++) {
            /**
             *  arr[i] 这个区间内都是以arr[i]为最小，所以乘以这么多个 arr[i]
             *  所有子数组的组合情况 其实就等于 包含i的区间的情况，然后包含i等于以i为最小值的辐射范围 . （肯定找不出一个不在辐射范围内的区间）
             *
             *  (1)每个元素E=A[i]的辐射范围都是一个连续数组，这个辐射范围内产生的所有子数组最小值都为E，因此E在每个子数组中对答案的贡献值都为E。如果这个辐射范围内的子数组有n个，那么总贡献值为n*E。
             *
             *  (2)那么这个辐射范围内能产生多少个子数组呢？我们枚举一下能产生多少个不同的左右边界对即可。假设辐射范围的左边界为left，右边界为right，元素E的下标为i，
             * 那么子数组的左边界应该在[left,i]中选取，子数组的右边界应该在[i,right]中选取。因此子数组个数为(i - left + 1) * (right - i + 1)(i−left+1)∗(right−i+1)
             *
             */
            ans = (ans + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) ans;
    }


    /**
     * 求子数组最小元素之和
     * （1）其实就是求，每个元素所能称为最小值的的区间 乘以 自身值 之和。 第一个元素1,在哪些连续子区间是最小的。第二个 +...+第N个
     * （2）怎么求每个最小值i对应的个数，左区间在[left,i]挑选，右区间在[i,right]中挑选。所以就是 (i-left[i]*(right[i]-i) * arr[i]
     * （3）怎么找到左右区间，用单调栈
     */
    public int sumSubarrayMins2(int[] arr) {

        //单调栈
        Stack<Integer> stack = new Stack<>();


        //左边离i最近的比arr[i]小的下标
        int[] left = new int[arr.length];
        int n = arr.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int ind = stack.peek();
                left[ind] = ind - i + 1;
            }
            stack.push(i);
        }

        stack.clear();
        //右边离i最近的比arr[i]小的下标
        int[] right = new int[arr.length];
        for (int i = 0; i < n; n++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int ind = stack.peek();
                left[ind] = ind - i + 1;
            }
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }

        return (int)ans;
    }


}
