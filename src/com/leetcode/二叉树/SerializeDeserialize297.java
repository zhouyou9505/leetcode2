package com.leetcode.二叉树;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 */
public class SerializeDeserialize297 {

    /**
     * 本体思路：
     * 1.序列化，就是按照先序遍历 3,5,Null,2,4,Null ，这样其实足够反序列化了
     * 2.返序列化 ，把string.split(",") 放到linkedList ，然后remove(0) 就是顺序的节点
     *
     * @return
     */
    public String serialize(TreeNode root) {
        return inorder(root, "");
    }

    private String inorder(TreeNode root, String str) {
        if (root == null) {
            return str + ",Null";
        }
        str += ("," + root.val);
        str = inorder(root.left, str);
        str = inorder(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length());

        String[] arr = data.split(",");
        LinkedList<String> linkedList = new LinkedList<String>(Arrays.asList(arr));
        return buildTree(linkedList);
    }


    private TreeNode buildTree(LinkedList<String> linkedList) {
        if (linkedList.isEmpty()) {
            return null;
        }
        String node = linkedList.remove(0);
        if ("Null".equals(node)) {
            return null;
        }
        int nodeVal = Integer.parseInt(node);
        TreeNode root = new TreeNode(nodeVal);
        root.left = buildTree(linkedList);
        root.right = buildTree(linkedList);
        return root;
    }

}
