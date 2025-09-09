package binarytree;

/**
 * Problem Statement:
 * Given the roots of two binary trees p and q, return true if they are structurally identical and the nodes have the same values.
 *
 * Tree p:      Tree q:
 *
 *     1             1
 *    / \           / \
 *   2   3         2   3
 *
 * Output: true
 *
 * Tree p:      Tree q:
 *
 *     1             1
 *    /               \
 *   2                 2
 *
 * Output: false
 */
public class SameTree {


    public static void main(String[] args){

        // Tree 1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = isSameTree(p, q);
        System.out.println("Are trees the same? " + result); // Expected: true

    }

    /**
     * Type	Value
     * Time	O(n) — visit every node
     * Space (call stack)	O(h) — height of tree
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p , TreeNode q){

       /* if(p == null && q != null) return false;
        if(p != null && q== null) return false;
        if(p == null && q == null) return true;*/
//same but more cleaner to check like this below
        if (p == null || q == null)
            return p == q;
    if(p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
