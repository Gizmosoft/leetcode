/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int value;
    public int diameterOfBinaryTree(TreeNode root) {
        value = 0;
        dfs(root);
        return value;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        value = Math.max(value, left+right);        // update diameter

        return Math.max(left, right) + 1;      
    }
}