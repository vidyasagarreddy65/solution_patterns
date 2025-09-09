package com.company.blind75.binarytree;


public class SubTreeOfAnotherSubtree {


    /**
     * Given two binary trees root and subRoot, return true if subRoot is a subtree of root.
     *
     * A subtree of a tree T is a tree consisting of a node in T and all of its descendants.
     *
     * Tree root:
     *       3
     *      / \
     *     4   5
     *    / \
     *   1   2
     *
     * Tree subRoot:
     *     4
     *    / \
     *   1   2
     *
     * Output: true ✅
     *
     *        3
     *        / \
     *       4   5
     *      / \
     *     1   2
     *        /
     *       0
     *
     *
     *  If root is:
     *
     *         3
     *        / \
     *       4   5
     *      / \
     *     1   2
     *
     *
     * And subRoot is:
     *
     *     4
     *    / \
     *   1   2
     *
     *
     * es! There can be multiple nodes in root with the same value as subRoot.val.
     *
     * You need to:
     *
     * Check each occurrence of that value
     *
     * Confirm structure + values match using isSameTree(...)
     *
     * 🔁 Example: Multiple Matching Roots
     * root:
     *         1
     *        / \
     *       1   1
     *          /
     *         2
     *
     * subRoot:
     *     1
     *    /
     *   2
     *
     *
     * You’ll hit 3 nodes with value 1, but only one of them is an exact match to subRoot.
     *
     * So yes — you must check every matching root candidate
     *
     * @param args
     */
    public static void main(String[] args){


        // Main Tree (root)
        //       3
        //      / \
        //     4   5
        //    / \
        //   1   2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Subtree (subRoot)
        //     4
        //    / \
        //   1   2
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);


        boolean result = isSubtree(root, subRoot);
        System.out.println("Is subRoot a subtree of root? " + result); // Expected: true


    }


    /**
     *
     * Time	O(m × n) worst case
     * Space	O(h) call stack (tree height)
     * @param root
     * @param subRoot
     * @return
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null ) return false;

        return isSameTee(root,subRoot) || isSubtree(root.right, subRoot) || isSubtree(root.left,subRoot) ;
    }

    public static boolean isSameTee(TreeNode p , TreeNode q){
        if(p == null || q == null) return p ==q;
        if (p.val != q.val) return false;
        return isSameTee(p.right,q.right) && isSameTee(p.left,q.left);
    }
}
