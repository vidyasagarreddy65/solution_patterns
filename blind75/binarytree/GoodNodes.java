package com.company.blind75.binarytree;

public class GoodNodes {

    public static void main(String[] args){
        // Test case 1: [3,1,4,3,null,1,5] - Expected: 4
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println("Test 1: " + goodNodes(root1)); // Expected: 4


        // Test case 2: [3,3,4,2] - Expected: 3
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        System.out.println("Test 2: " + goodNodes(root2)); // Expected: 3

        // Test case 3: [1] - Expected: 1
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3: " + goodNodes(root3)); // Expected: 1
    }


    /**
     * Let's Trace Through Example:
     * Tree: [3,3,4,2], Initial call: countGoodNodes(root, result, Integer.MIN_VALUE)
     * countGoodNodes(3, result, -∞):
     *   ✓ 3 ≥ -∞ → count++, result[0] = 1
     *
     *   countGoodNodes(3_left, result, max(3,-∞)=3):
     *     ✓ 3 ≥ 3 → count++, result[0] = 2
     *
     *     countGoodNodes(4, result, max(3,3)=3):
     *       ✓ 4 ≥ 3 → count++, result[0] = 3
     *
     *     countGoodNodes(2, result, max(3,3)=3):
     *       ✗ 2 < 3 → no count
     *
     * Final result: 3 ✅
     * @param root
     * @return
     */
    public static int goodNodes(TreeNode root) {
        // Your implementation here

        int[] result = {0};

        countGoodNodes(root,result, Integer.MIN_VALUE);
        return result[0];
    }


    /**
     * Exactly right! 🎯
     * Complexity Analysis:
     * Time Complexity: O(N)
     *
     * N = number of nodes in the tree
     * We visit each node exactly once
     * At each node: constant time operations (comparison, Math.max, counter increment)
     * Total: O(N)
     *
     * Space Complexity: O(H)
     *
     * H = height of the tree
     * Space used by recursion call stack
     * Each recursive call adds one frame to the stack
     * Maximum depth = height of tree
     *
     * Space Breakdown:
     *
     * Best case (balanced tree): O(log N) - height ≈ log N
     * Worst case (skewed tree): O(N) - height = N
     * Additional space: O(1) for variables (result array, currentPathMax)
     * @param node
     * @param result
     * @param currentPathMax
     */
    public static void countGoodNodes(TreeNode node, int[] result, int currentPathMax){

        if(node == null) return ;

        if(node.val >= currentPathMax){
            result[0] = result[0]+1;
        }
        countGoodNodes(node.left,result,Math.max(node.val, currentPathMax));

        countGoodNodes(node.right,result,Math.max(node.val, currentPathMax));



    }



}
