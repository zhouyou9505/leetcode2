package com.leetcode.二叉树;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 序列化和反序列化N叉树Codec428 {


    /**
     * dfs 根左右的方式存下整个多叉树  cz = childSize
     * root1#size1#chid1#cz1#chid2#cz2#root2#rz2...
     * @param root
     * @return
     */
    public String serialize(Node root) {
        String res  = dfs(root);
        return res;
    }

    String dfs(Node root){
        if(root == null){
            return "";
        }
        String str = (root.val + "#" + root.children.size() + "#");
        if (root.children.isEmpty()){
            return str;
        }
        for(Node c : root.children){
            str += dfs(c);
        }
        return str;
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Deque<String> deque = new LinkedList<>();
        String[] arr = data.split("#");
        for(String s : arr){
            if (!"".equals(s)){
                deque.addLast(s);
            }
        }

        return buildTree(deque);
    }


    public Node buildTree(Deque<String> deque){
        if (deque.isEmpty()){
            return null;
        }
        int val = Integer.parseInt(deque.removeFirst());
        int size = Integer.parseInt(deque.removeFirst());
        Node root = new Node(val);
        List<Node> children = new ArrayList<>();
        while(size > 0){
            children.add(buildTree(deque));
            --size;
        }
        root.children = children;
        return root;
    }

}
