package com.leetcode;


import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
 * 本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。
 *
 * 算法流程：
 *
 * 构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
 *      当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
 *      当 c 为字母时，在 res 尾部添加 c；
 *      当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 00：
 *          记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
 *          记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
 *          进入到新 [ 后，res 和 multi 重新记录。
 *      当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
 *          last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
 *          cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
 * 返回字符串 res。
 *
 */
public class DecodeString394 {

    public static void main(String[] args) {
        System.out.println(new DecodeString394().decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
        LinkedList<String> strList = new LinkedList<String>();
        LinkedList<Integer> valList = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        int multi = 0;

        for(char c : s.toCharArray()){
            if(c == '['){
                //把值临时存着
                strList.addLast(sb.toString());
                valList.addLast(multi);
                multi = 0;
                sb = new StringBuilder();
            }else if(c == ']'){

                String tmp = "";
                int count = valList.removeLast();
                for(int i=0;i<count;i++){
                    tmp += sb.toString();
                }

                sb = new StringBuilder(strList.removeLast() + tmp);
            }else if(c>='0' && c<'9'){
                multi = multi * 10 + (c-'0');
            }else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
