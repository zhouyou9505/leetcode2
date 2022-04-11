package com.leetcode;

public class PathSum437 {


    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        //遍历节点
        int lCount = pathSum(root.left,targetSum);

        int rCount = pathSum(root.right,targetSum);

        //该路径深度遍历求和
        return dfsCount(root,0,targetSum) + lCount + rCount;
    }


    public int dfsCount(TreeNode root, int prev, int targetSum){
        int count = 0;

        if (root == null){
            return 0;
        }

        prev = prev + root.val;

        //dfs遍历节点
        if(prev == targetSum){
            ++count;
        }



        return count+dfsCount(root.left,prev,targetSum)
                + dfsCount(root.right,prev,targetSum);
    }

}
