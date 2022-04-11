package com.leetcode;

import java.util.*;

public class LeastInterval621 {

    public static void main(String[] args) {

    }

    class Solution {


        /**
         总共分为三种情况
         1.少 n=2 这种有冷却时间
         a b
         a 冷
         a

         1.少 n=2 这种有冷却时间。这个时候明确不了就用 max(tasks.length, (maxCount-1)*(n+1))，这样
         就能看数量能不能填充满这个体积，task.length大说明充满了，没有冷却时间浪费，就按照tasks.lengt来
         a b c
         a b c
         a

         2.正好 n=2 这种正好填充，tasks.length == 计算结果
         a b
         a b
         a b
         a b

         3.很多 n=2， 桶大小设置为3   超出了整个 m*(n+1)其实一点冷却时间都没有，多少任务就是多少时间
         a b c d
         a b c
         a b c


         */


        public int leastInterval(char[] tasks, int n) {

            int maxWordCount = 0;
            Map<Character,Integer> map = new HashMap<Character,Integer>();

            //计算最多出现的字符次数
            for(int i=0;i<tasks.length;i++){
                int count =  map.getOrDefault(tasks[i],0);
                ++count;
                map.put(tasks[i],count);
                maxWordCount = Math.max(maxWordCount,count);
            }


            //算最后一个桶的数量
            int same = 0;
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if(maxWordCount == entry.getValue()){
                    same++;
                }
            }

            System.out.println("same="+same);

            //如果最后一个桶是满的，说明其实没有冷却等待时间
            //那就看面积大还是数量大
            return Math.max(tasks.length,(maxWordCount-1) * (n+1) + same);
        }
    }
}
