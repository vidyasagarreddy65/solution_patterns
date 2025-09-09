package com.company.blind75.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    /**
     *
     * Problem Summary:
     *
     * You are given two integer arrays preorder and inorder where:
     *
     * preorder is the preorder traversal of a binary tree.
     *
     * inorder is the inorder traversal of the same tree.
     *
     * Construct the binary tree and return its root.
     * @param args
     *
     * Traversal	Visit Order	Root Position
     * Preorder	Root → Left → Right	First
     * Inorder	Left → Root → Right	Middle
     * Postorder	Left → Right → Root	Last
     */
    static Map<Integer,Integer>  indexMapInorder = new HashMap<>();
    //Revist
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder =  {9, 3, 15, 20, 7};
        for (int i = 0; i < inorder.length; i++) {
            indexMapInorder.put(inorder[i],i);
        }
        TreeNode root = build(preorder, 0, inorder.length-1);

        // To verify: print inorder of the constructed tree
        System.out.print("Inorder of constructed tree: ");
        printInorder(root);

    }


    static int preOrderIndex = 0;

    /**
     * So you should stick with:
     *
     * ✅ Time: O(n)
     * ✅ Space: O(n)
     * @param preOrder
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static TreeNode build(int[] preOrder, int startIndex, int endIndex){

// Base case
        if(startIndex > endIndex) return null;

        int rootVal = preOrder[preOrderIndex++];
        // Get current root from preorder
        TreeNode node = new TreeNode(rootVal);
        // Find index of root in inorder[]
        int index = indexMapInorder.get(rootVal);
        // Recursively build left and right subtrees
        node.left = build(preOrder, startIndex, index-1);
        node.right = build(preOrder, index+1, endIndex);

        return node;

    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
