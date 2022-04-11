package com.leetcode.字符串;

public class ReverseWords151 {

    public static void main(String[] args) {
        new ReverseWords151().reverseWords(" fun   is leetcode  ");
    }

    /**
     * 本题的思路：
     * 1.把整个字符串反过来，存到StringBuilder上 'edocteel si nuf'
     * 2.用for来遍历每个单词,单词用while(end<length && endStr != ' ')来分隔每个单词
     */
    public String reverseWords(String s) {

        //反转整个字符串，用一个新的StringBuilder承载 反转的String => edocteel si nuf
        StringBuilder sb = reverseString(s);

        //反转每个单词，用StringBuilder的charAt和setCharAt每个单词的字符串的反转
        return reverse(sb);
    }


    public String reverse(StringBuilder sb) {
        for (int start = 0; start < sb.length() - 1; start++) {
            if (sb.charAt(start) == ' '){
                continue;
            }
            int end = start;
            while (end < sb.length() && sb.charAt(end) != ' ') {
                ++end;
            }
            reverseSB(sb, start, end-1);
            start = end-1;
        }
        return sb.toString();
    }

    public void reverseSB(StringBuilder sb, int start, int end) {
        while (start < end) {
            char a = sb.charAt(start);
            char b = sb.charAt(end);
            sb.setCharAt(start, b);
            sb.setCharAt(end, a);
            ++start;
            --end;
        }
    }

    public StringBuilder reverseString(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = right; i >= left; i--) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
        }
        return sb;
    }

}
