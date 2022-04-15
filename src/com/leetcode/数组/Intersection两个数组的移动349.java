package com.leetcode.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection两个数组的移动349 {




    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums1){
            map.put(n,1);
        }


        List<Integer> list = new ArrayList<>();
        for(int n: nums2){
            Integer count = map.get(n);
            list.add(count);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
