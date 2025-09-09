package com.company.blind75.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree2 {

    /**
     * 🌳 Problem #39: Construct Binary Tree from Inorder and Postorder Traversal
     *🔢 Problem Statement:
     *
     * Given two integer arrays inorder and postorder where:
     *
     * inorder is the inorder traversal of a binary tree.
     *
     * postorder is the postorder traversal of the same tree.
     *
     * Construct and return the binary tree.
     *
     * @param args
     */
    public static void main(String[] args){

        // Example input
        int[] inorder =    {9, 3, 15, 20, 7};
        int[] postorder =  {9, 15, 7, 20, 3};

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i],i);

        }
        postOrderIndex = postorder.length-1;
        System.out.print("Inorder of constructed tree: ");
        printInorder(build(postorder, 0, inorder.length-1));
    }

    static Map<Integer,Integer> inorderIndexMap = new HashMap<>();
    static int postOrderIndex =0;

    public static TreeNode build(int[] postOrder, int startIndex, int endIndex){

        if(startIndex> endIndex) return  null;

        int rootVal = postOrder[postOrderIndex--];
        TreeNode node = new TreeNode(rootVal);

        int index = inorderIndexMap.get(rootVal);


        node.right = build(postOrder,index+1 ,endIndex);
        node.left = build(postOrder,startIndex ,index-1);


        return node;
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

}
