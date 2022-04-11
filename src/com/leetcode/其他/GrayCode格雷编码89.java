package com.leetcode.其他;

import java.util.ArrayList;
import java.util.List;

public class GrayCode格雷编码89 {

    public static void main(String[] args) {
        System.out.println(new GrayCode格雷编码89().grayCode2(3));
    }

    /**
     *
     * https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
     *
     * 格雷g(n)=g(n-1) 的每一个元素的最前面补0 和补1。如果是这种思路用递推和动态规划的思路应该是都能解决的。
     * 解法中有两处巧妙的逻辑:
     * 1.对于首位补0和首位补1的逻辑 :首位补1=head+res.get(j) ;首位补00=原数(不需要处理)
     * 2.镜像的处理使用。int j=res.size() - 1
     */

    /**
     * 000
     *
     * 001
     *
     * 010
     * 011
     * --------上下镜像，只不过下面多了一个head前缀
     * 111
     * 110
     * 101
     * 100
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int head = 1;
        for (int i = 1; i <= n; i++) {
            int rSize = result.size();
            for (int j = rSize - 1; j >= 0; j--) {
                result.add(head + result.get(j));
            }
            head = head << 1;
        }
        return result;
    }


    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));  //其实就是前面首位一直在补1，res.get(j)是镜像
            }
            head <<= 1; // 0 -> 10 -> 100
        }
        return res;
    }


}
