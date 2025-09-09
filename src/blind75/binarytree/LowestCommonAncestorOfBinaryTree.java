package binarytree;

public class LowestCommonAncestorOfBinaryTree {

    /**
     * Tree Used for All Examples:
     *         3
     *        / \
     *       5   1
     *      / \ / \
     *     6  2 0  8
     *       / \
     *      7   4
     *
     * 🔁 Example 1: p = 5, q = 1
     *
     * 5 is in the left subtree of 3
     *
     * 1 is in the right subtree of 3
     *
     * 🟢 Answer: 3
     * 3 is the first node where both children lead to p and q.
     *
     * 🔁 Example 2: p = 5, q = 4
     *
     * 4 is in the left subtree, under node 2, which is under node 5
     *
     * So, 5 is an ancestor of 4
     *
     * 🟢 Answer: 5
     * Because 5 contains both itself and 4 in its subtree.
     *
     * 🔁 Example 3: p = 2, q = 4
     *
     * 4 is a right child of 2
     *
     * 2 is an ancestor of 4
     *
     * 🟢 Answer: 2
     *
     * 🔁 Example 4: p = 7, q = 4
     *
     * Both nodes are children of node 2
     *
     * 🟢 Answer: 2
     *
     * 🔁 Example 5: p = 0, q = 8
     *
     * Both are direct children of node 1
     *
     * 🟢 Answer: 1
     *
     * 🔁 Example 6: p = 6, q = 7
     *
     * 6 is under node 5
     *
     * 7 is under 2, which is under 5
     *
     * 🟢 Answer: 5
     * @param args
     */
    public static void main(String[] args) {
        // Build the tree:
        //         3
        //        / \
        //       5   1
        //      / \ / \
        //     6  2 0  8
        //       / \
        //      7   4

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left; // Node 5
        TreeNode q = root.right; // Node 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA: " + lca.val); // Expected: 3
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null) return null;
        if (root == p || root == q) return root;


        TreeNode left = lowestCommonAncestor(root.left,p,q );

        TreeNode right = lowestCommonAncestor(root.right,p,q );


        if(left != null && right != null ) return root;//Both sides found something → this node is the lowest common ancestor.

       return left != null ? left: right;//If one side found a match, return that match upward.
    }



}
