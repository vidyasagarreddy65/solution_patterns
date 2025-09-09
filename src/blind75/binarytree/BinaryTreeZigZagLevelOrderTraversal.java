package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {

    /**
     * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
     * (First level left→right, second level right→left, third left→right, and so on.)
     *
     * Example 1
     * Input: root = [3,9,20,null, null,15,7]
     * Output: [[3],[20,9],[15,7]]
     *
     * Example 2
     * Input: root = [1]
     * Output: [[1]]
     *
     * Example 3
     * Input: root = []
     * Output: []
     */
    public static void main(String[] args) {

        // Build tree manually for [3,9,20,null,null,15,7]
        //
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(21);

    System.out.println(zigzagLevelOrder(root));
    }


    /**
     * Complexity
     *
     * Time: O(N)
     *
     * Space: O(W) where W = max width of the tree
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();

        boolean directionLeftToRight = true;
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();

            int levelSize = queue.size();

            for (int i = 0; i <levelSize ; i++) {
                TreeNode curr  = queue.poll();
                levelList.add(curr.val);

                if(directionLeftToRight){
                    if(curr.right != null) queue.add(curr.right );
                    if(curr.left != null) queue.add(curr.left );
                }else{
                    if(curr.left != null) queue.add(curr.left );
                    if(curr.right != null) queue.add(curr.right );
                }

            }
            directionLeftToRight = !directionLeftToRight;
            result.add(levelList);


        }





        return result;
    }

}
