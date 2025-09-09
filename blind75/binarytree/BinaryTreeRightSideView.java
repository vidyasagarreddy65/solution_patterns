package com.company.blind75.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {


    /**
     *Statement:
     * Given the root of a binary tree, imagine yourself standing on the right side of it.
     * Return the values of the nodes you can see, ordered from top to bottom.
     *Input: root = [1,2,3,null,5,null,4]
     * Output: [1,3,4]
     *
     * Explanation:
     *
     *     1            ← right side view: [1,3,4]
     *    / \
     *   2   3
     *    \    \
     *     5    4
     *
     */

    public static void main(String[] args){

        // Build tree manually for [1,2,3,null,5,null,4]
        //
        //        1
        //       / \
        //      2   3
        //       \    \
        //        5    4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);


        System.out.println(rightSideView(root));
    }

    /**
     * O(N) And O(W) Max widht of the tree
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        // your BFS code here
        List<Integer> result = new ArrayList<>();
        if(root == null)  return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            result.add(queue.peek().val);
            for (int i = 0; i < levelSize; i++) {
               TreeNode curr =  queue.poll();
                if(curr.right != null) queue.add(curr.right);
                if(curr.left != null) queue.add(curr.left);
            }
        }


        return result;
    }

    // Follow up will be to add DFS,
}
