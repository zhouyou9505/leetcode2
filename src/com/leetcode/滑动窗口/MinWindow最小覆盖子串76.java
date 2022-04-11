package com.leetcode.滑动窗口;

public class MinWindow最小覆盖子串76 {


    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     * 本题思路：
     * 1、使用滑动窗口来找到最合适的窗口，left,right=0，先移动right，等符合条件再移动left。然后再left++,right++,再靠移动right，和left
     * 2、将t存到数组中，表示t出现的数字及频次，通过left，right来指针s字符串，来表示是否全部包含了t的字符及频次
     * 文中使用了 count和tArr(频次数组)来判断是否全部包含。正常的情况下是 tArr[t中的字符]=x 每个t的字符是否都为0，但是每次都要确认一遍。所以直接count来记录
     */
    public String minWindow(String s, String t) {

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        int start = 0;
        int[] tArr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            //todo 这样t中出现的字符及频次就标记好了
            tArr[t.charAt(i)]++;
        }

        //开始滑动了
        while (right < s.length()) {

            //看在窗口内的字符能抵消多少个tArr中的字符及频次
            char s1 = s.charAt(right);
            if (tArr[s1] > 0) {
                --count;
            }

            //不仅是存在区间的要减去，1->0 这样就抵消了t的字符频次。
            //0->-1这种也要标记下来，用来标记s在t中的无效字符
            tArr[s1]--;

            //count==0说明已经存在,right已经到达合适的位置
            if (count == 0) {
                //现在让left也达到合适的位置,因为tArr[s.charAt(left)]<0，说明 s.charAt(left)是无效的
                while (left < right && tArr[s.charAt(left)] < 0) {
                    tArr[s.charAt(left)]++; //为什么要++， 因为比如 acdcb cb . 最开始的c对应的标记是-1，说明有一个c是无效的，left可以继续往右移动
                    ++left;
                }

                //窗口的最小值
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                //该left对应的有效字符从随着左边的窗口移动，重新在tArr暴露了出来，期待下一个窗口 tArr[s1]来和他碰撞
                tArr[s.charAt(left)]++;
                ++left;
                ++count;
            }
            ++right;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}
