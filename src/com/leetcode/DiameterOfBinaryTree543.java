package com.leetcode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 */
public class DiameterOfBinaryTree543 {

    int max = 1;

    /**
     * 这道题就是比较每个节点的左右最大深度之和进行比较。
     * 1.如果比较每个节点：用dfs遍历每个节点，并且在节点时记录 maxLeftDepth + maxRightDepth + 1 和 max比较
     * 2.既然时节点最大深度 maxRootDepth（root.left） => left的左右最大长度 +1就是 root.left最大长度
     * 3.有了每个节点的长度通过return返回到上一层，父节点就可以求出最大直径了
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxRootDepth(root);
        return max-1;
    }

    public int maxRootDepth(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = maxRootDepth(root.left);

        int right = maxRootDepth(root.right);

        //返回这个节点的深度，并且偷偷记录一下直径
        max = Math.max(left+right+ 1,max);

        return Math.max(left,right) + 1;//等于这个节点的depth
    }

}
