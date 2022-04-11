package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum560 {

    /**
     * 前缀和解法：
     * 求：nums[a]+..+nums[b] = target
     *
     * 1、只要 pre[i] - pre[j-1] = target => map.containsKey(pre[i]-target)  一定是一段连续的 nums[a]+..+nums[b]。不管你是在哪段
     *
     * 看当前连续的数组相加 - target 是否在map中能找到前缀，  1312 ，target=3  在下标4的时候，找了map.contains(7-target)
     * 然后把 7也存到map中
     */
    public int subarraySum(int[] nums, int k) {

        int pre = 0;

        int count = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            pre += nums[i];
            //不担心碰到之前的数组之和吗？ 前缀和的好处， 1 3 1 2
            //k等于3，那么 map.contains(4-3)=>(1)  , map.contains( 7 - 3) => (1,3)
            //有没有可能pre-k产生的数据是前面不连续的子数组的和？？  比如说 1 3 x1 x2， containsKey(pre-target3 => 4)，那说明x1+x2一定==target3
            if(map.containsKey(pre-k)){
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }

        return count;
    }


    /**
     * 本体思路：
     * 1.第一层for循环起点。第二层for循环 sum+=nums[j] ,因为shi subArray所以必须是连续的
     * fori
     *  forj
     *      sum+=nums[j]
     *      if(sum == k){
     *          ++count;
     *      }
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {

        //子数组之和
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if( sum == k){
                    ++count;
                }
            }
        }
        return count;
    }
}
