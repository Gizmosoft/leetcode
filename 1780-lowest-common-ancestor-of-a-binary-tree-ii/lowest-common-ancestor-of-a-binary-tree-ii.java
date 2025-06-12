/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // find lca of p and q
        TreeNode lcaNode = lca(root, p, q);

        if(lcaNode == p) {
            return areNodesFound(p, q) ? p : null;
        }
        else if(lcaNode == q) {
            return areNodesFound(q, p) ? q : null;
        }
        return lcaNode;
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lca(root.left ,p, q);
        TreeNode right = lca(root.right ,p, q);

        if(left != null && right != null) return root;
        else if(left != null) return left;
        else return right;
    }

    private boolean areNodesFound(TreeNode root, TreeNode target) {
        if(root == target) return true;
        if(root == null) return false;
        return areNodesFound(root.left, target) || areNodesFound(root.right, target);
    }
}