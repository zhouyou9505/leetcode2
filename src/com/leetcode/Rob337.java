package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 II
 */
public class Rob337 {

    /**
     备忘录法
     */
    Map<TreeNode, Map<Boolean,Integer>> map;

    public int rob(TreeNode root) {

        map = new HashMap<TreeNode,Map<Boolean,Integer>>();

        return Math.max(maxDpVal(root,false),maxDpVal(root,true));

    }

    /**
     includeMe是root有没有被加上
     */
    public int maxDpVal(TreeNode root, boolean includeMe){
        if(root == null){
            return 0;
        }

        //如果这个节点的被记录过
        if(map.get(root) != null && map.get(root).get(includeMe) != null){
            return map.get(root).get(includeMe);
        }

        int max1 = 0;
        if(!includeMe){
            //max1代表自己+孙子 因为我传了true，儿子节点的值不会被加上
            max1 = root.val + maxDpVal(root.left,true) + maxDpVal(root.right,true);
        }

        //max2表示 儿子节点的动规最大
        int max2 = maxDpVal(root.left,false) + maxDpVal(root.right,false);

        //比较 自己+孙子动规大 还是  儿子动规大，返回则是自己动规大
        int realMax = Math.max(max1,max2);

        Map<Boolean,Integer> map1 = new HashMap<Boolean,Integer>();

        map1.put(includeMe,realMax);
        map.put(root,map1);

        return realMax;
    }

    /**
     * 总结： dp[1],dp[2],dp[3] dp[3]不是基于dp[2]的，而是 value3+dp[1]和dp[2]左比较，放弃dp[2]，
     */
}
