package binarytree;

public class ValidateBST {


    /**
     * Today's Problem: Validate Binary Search Tree
     * LeetCode Link: #98 - Validate Binary Search Tree
     * Problem Statement:
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     * A valid BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key
     * The right subtree of a node contains only nodes with keys greater than the node's key
     * Both the left and right subtrees must also be binary search trees
     * @param args
     */
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test 1: " + isValidBST(root1)); // Expected: true

// Test case 2: [5,1,4,null,null,3,6] - should return false
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test 2: " + isValidBST(root2)); // Expected: false

        // Test case 3: [10,5,15,null,null,6,20] - should return false
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println("Test 3: " + isValidBST(root3)); // Expected: false




    }


    /**
     * O(N) and Space O(H)
     *
     * Time Complexity: O(N)
     *
     * N = number of nodes in the tree
     * We visit each node exactly once
     * At each node, we do constant work: comparison + 2 recursive calls
     * Best case: O(N) - balanced tree, still visit all nodes
     * Worst case: O(N) - skewed tree, still visit all nodes
     *
     * Space Complexity: O(H)
     *
     * H = height of the tree
     * Space is used by the recursion call stack
     * Best case: O(log N) - balanced binary tree (H = log N)
     * Worst case: O(N) - completely skewed tree (H = N)
     *
     * Visual Example:
     * Balanced Tree (Best Space):
     *        4
     *       / \
     *      2   6
     *     / \ / \
     *    1  3 5  7
     *
     * Height = 3, Space = O(3) = O(log 7)
     *
     * Skewed Tree (Worst Space):
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *
     * Height = 4, Space = O(4) = O(N)
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root){
        return validBSTRange(root,  Integer.MIN_VALUE,Integer.MAX_VALUE);
    }


    public static boolean validBSTRange(TreeNode node,long minVal, long maxVal){


        if(node == null) return  true;

        if(node.val >= maxVal || node.val <= minVal ) return false;


       return  validBSTRange(node.left, minVal, node.val) && validBSTRange(node.right,node.val , maxVal);

    }




}
