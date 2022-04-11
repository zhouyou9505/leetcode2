package com.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/xian-pai-xu-zai-cha-dui-dong-hua-yan-shi-suan-fa-g/
 */
public class ReconstructQueue406 {

    public int[][] reconstructQueue(int[][] people) {

        int len = people.length;

        /**
         * 1.如果身高相同，那就按照 谁前面少 进行排序。原因：合情合理
         * 2.如果身高不同，就按照身高高到低排序。原因：这样就知道前面有几个人比我高，第二维度就能用上
         *
         * 一定要经过排序，才能for循环，如果我直接for循环，把位置查到对应的下标，那其实不是真正的下标。
         * 比如说 我当前是4:4，但是5:1还在4:4后面，我4：4排在第4（！！一定是排序好后的第四！！），但是等5:1过来后，就会把4：4挤到后面，这样 4就不正确了
         */
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        List<int[]> list = new LinkedList<>();

        for(int i=0;i<people.length;i++){
            if(list.size() > people[i][1]){
                //直接插入到people[i][1]的下标上，前面的排序保证了一定是插入到people[i][1]，因为在它前面，没有比它大的数，所以的他的people[i][1]决定他的位置
                list.add(people[i][1],people[i]);
            }else {
                //如果它前面有比list.size()的人还多，那就放最后一个
                list.add(list.size(),people[i]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }


}
