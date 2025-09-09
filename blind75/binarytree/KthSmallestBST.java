package com.company.blind75.binarytree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBST {

    public static void main(String[] args){

        // Test case 1: [3,1,4,null,2], k = 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println("Test 1: " + kthSmallest(root1, 1)); // Expected: 1

        // Test case 2: [5,3,6,2,4,null,null,1], k = 3
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        System.out.println("Test 2: " + kthSmallest(root2, 3)); // Expected: 3

        // Test case 3: Simple case [1], k = 1
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3: " + kthSmallest(root3, 1)); // Expected: 1

    }


    /**
     * O(N) and O(N)
     * @param node
     * @param n
     * @return
     */
    public static int kthSmallest(TreeNode node, int n){

        List<Integer> inorderList = new ArrayList<>();

        inOrder(node, inorderList, n);

        return inorderList.get(n-1) ;

    }


    /**
     *
     * Advantages:
     *
     * ✅ Early termination - stops as soon as we have k elements
     * ✅ Simple logic - no extra counters needed
     * ✅ Clean code - very readable
     * ✅ Optimal for small k - visits only ~k nodes instead of all N
     *
     * Time Complexity: O(k + log N) in balanced trees, O(k) elements + traversal to reach them
     * Space Complexity: O(k) for the list + O(H) recursion
     * Outstanding solution! This shows real algorithmic thinking.
     * @param node
     * @param inorderList
     * @param n
     */
    //Follow up if k is very small compared to n you can same lot of
    public static void inOrder(TreeNode node, List<Integer> inorderList, int n){

        if(node == null) return ;
        if(inorderList.size() == n) return ;

        inOrder(node.left,inorderList, n);
        inorderList.add(node.val);
        inOrder(node.right,inorderList,n);
    }
}
