package binarytree;

public class MaxDepthBinaryTree {

    /**
     * Problem Statement:
     * Given the root of a binary tree, return its maximum depth.
     * Definition:The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * Input:
     *         3
     *        / \
     *       9  20
     *          / \
     *         15  7
     * Output: 3
     * @param args
     *
     * Complexity	Value
     * Time	O(n)
     * Space	O(h)
     * Best Space	O(log n) (balanced)
     * Worst Space	O(n) (skewed)
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root, 0);
        System.out.println("Max Depth: " + depth); // Expected: 3
    }


    public static int maxDepth( TreeNode treeNode, int h){
        if (treeNode == null) return h;
        return Math.max(
                maxDepth(treeNode.right, h+1),
                maxDepth(treeNode.left, h+1)
                );
    }

}
