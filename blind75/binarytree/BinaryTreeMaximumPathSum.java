package com.company.blind75.binarytree;

public class BinaryTreeMaximumPathSum {


    /**
     * Statement:
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes has an edge connecting them. A path does not need to pass through the root, and it must contain at least one node.
     * The path sum is the sum of the node values along the path.
     * Return the maximum path sum of any non-empty path.
     * @param args
     */

    ///HIGH Revist is needed on this solution
    public static void main(String[] args){

            // Example 1: [1,2,3]  -> expected max path sum = 6 (2 -> 1 -> 3)
        TreeNode ex1 = new TreeNode(1);
        ex1.left = new TreeNode(2);
        ex1.right = new TreeNode(3);



        // Example 2: [-10,9,20,null,null,15,7]  -> expected = 42 (15 -> 20 -> 7)
        TreeNode ex2 = new TreeNode(-10);
        ex2.left = new TreeNode(9);
        ex2.right = new TreeNode(20);
        ex2.right.left = new TreeNode(15);
        ex2.right.right = new TreeNode(7);


        TreeNode ex3 = new TreeNode(-3);

        TreeNode ex4 = new TreeNode(2);
        ex4.left = new TreeNode(-1);


        System.out.println(BinaryTreeMaximumPathSum.maxPathSum(ex1)); //6
         System.out.println(BinaryTreeMaximumPathSum.maxPathSum(ex2)); //42
         System.out.println(BinaryTreeMaximumPathSum.maxPathSum(ex3)); //-3
        System.out.println(BinaryTreeMaximumPathSum.maxPathSum(ex4)); //2
    }

    private static int maxSum;


    public static int maxPathSum(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;

    }

    public static int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }


        int leftGain = Math.max(dfs(root.left), 0);
        int rightGain = Math.max(dfs(root.right), 0);

        int pathSum = leftGain + rightGain + root.val;
        maxSum = Math.max(maxSum, pathSum);
        return maxSum;

    }
}
