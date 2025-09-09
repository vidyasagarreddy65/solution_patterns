package com.company.blind75.binarytree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem #33 — Invert Binary Tree
 *
 * Statement:
 * Given the root of a binary tree, invert the tree (mirror it) and return its root.
 *
 * Examples:
 *
 * Example 1
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Explanation:
 *
 *     4            4
 *    / \          / \
 *   2   7   →    7   2
 *  / \ / \      / \ / \
 * 1  3 6  9    9  6 3  1
 */
public class InvertBinaryTree {


    public static void main(String[] args){


        // Build tree manually:
        //      4
        //     / \
        //    2   7
        //   / \ / \
        //  1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);


        printInOrder(invertBinaryTree(root));

    }

    /** printing the array inorder traveral where left node and right
     *
     *
     * @param node
     */
    private static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }


    /**
     * Time Complexity: O(n) → every node is visited once.
     *
     * Space Complexity: O(h) recursion stack (where h = height of the tree).
     *
     * Worst case (skewed tree): O(n)
     *
     * Best case (balanced tree): O(log n)
     * @param node
     * @return
     */
    public static TreeNode invertBinaryTree(TreeNode node){

        if( node == null) return null;

        //SWAP the left and right
        TreeNode temp = node.left;
        node.left = node.right;
        node.right= temp;


        invertBinaryTree(node.left);

        invertBinaryTree(node.right);

        return node;
    }



    // solve with BFS as

    /**
     * Time Complexity: O(n) (each node enqueued/dequeued once).
     *
     * Space Complexity: O(w), where w = maximum width of the tree.
     *
     * Worst case ~ O(n) (for a perfectly balanced tree at the bottom level).
     * @param node
     * @return
     */
    public static TreeNode invertBinaryTreeBFS(TreeNode node){

        Queue<TreeNode>  queue = new LinkedList<>();
        if(node == null)  return null;
        queue.add(node);

        while(!queue.isEmpty()){

            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right= temp;
           if(curr.left != null ) queue.add(curr.left);
            if(curr.right != null )  queue.add(curr.right);
        }


        return  node;


    }

}
