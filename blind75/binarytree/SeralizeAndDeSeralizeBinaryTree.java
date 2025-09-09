package com.company.blind75.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SeralizeAndDeSeralizeBinaryTree {


    /**
     * Problem: Serialize and Deserialize Binary Tree
     * 🔧 Using Preorder Traversal + "null" markers (Optimal Approach)
     * @param args
     */
    public static void main(String[] args){
        // Construct test tree:
        //      1
        //     / \
        //    2   3
        //       / \
        //      4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        System.out.println("Serialized Tree: " + serialize(root));

        TreeNode deserializedRoot = deserialize(serialize(root));

        System.out.print("Inorder of Deserialized Tree: ");
        printInorder(deserializedRoot);
    }

    // Optional: to verify correctness
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static String serialize(TreeNode root) {
        // Preorder + nulls (e.g., 1,2,null,null,3,4,null,null,5,null,null)
        StringBuilder result = preOrder(root,new StringBuilder());
        return result.substring(0, result.length()-1);
    }


    public static StringBuilder preOrder(TreeNode root,StringBuilder result){
        if(root == null) {
            return result.append("null,");
        }
        result.append(root.val +",");
        preOrder(root.left,result);
        preOrder(root.right,result);

        return result;
    }


    public static TreeNode deserialize(String data) {
        // Preorder + nulls (e.g., 1,2,null,null,3,4,null,null,5,null,null)
        if (data == null || data.isEmpty()) return null;
        String[] tokens = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(tokens));
        return build(queue);
    }

    private static  TreeNode build(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(queue);
        node.right = build(queue);
        return node;
    }

}
