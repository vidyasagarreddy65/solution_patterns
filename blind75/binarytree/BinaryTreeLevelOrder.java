package com.company.blind75.binarytree;

import java.util.*;

/*
Statement:
Given the root of a binary tree, return the level order traversal of its nodes’ values.
(i.e., from left to right, level by level).

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]


Input: root = [1]
Output: [[1]]

Input: root = []
Output: []


 */
public class BinaryTreeLevelOrder {


    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);



        System.out.println(levelOrder(root));
        System.out.println(levelOrder1(root));
    }


    /**
     * O(N) and space Space: O(W) — W = max width of the tree (peak queue + current level list).
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();

        if(root == null){
            return  new ArrayList<>();
        }
        queue.add(root);
        List<Integer> levelList;
        while(!queue.isEmpty()){
            levelList = new ArrayList<>();
            int currLevel = queue.size();
            while(currLevel !=0){
                TreeNode curr = queue.poll();
                levelList.add(curr.val);
                if(curr.left != null)  queue.add(curr.left);
                if(curr.right != null)  queue.add(curr.right);
                currLevel= currLevel-1;
            }
            results.add(levelList);
        }
        // your code here
        return results;
    }


    //*Minor SD2/SD3 polish (optional):
    //
    //Prefer ArrayDeque<> over LinkedList<> for queues (faster, no node object overhead).
    //
    //Tiny style tweak: use a for loop over currLevel instead of while(currLevel != 0).


    public static List<List<Integer>> levelOrder1(TreeNode root) {


        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> results = new ArrayList<>();

        if(root == null){
            return  results;
        }
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer>  level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i <levelSize ; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left != null)  queue.add(curr.left);
                if(curr.right != null)  queue.add(curr.right);
            }
            results.add(level);
        }
        return results;
    }



}
