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
    public int sumEvenGrandparent(TreeNode root) {
        return getSum(root, null, null);  
    }
    
    public int getSum(TreeNode root, TreeNode parent, TreeNode grandparent){
        if(root == null)
            return 0;
        
        int res = 0;
        
        if(grandparent != null && grandparent.val % 2 == 0){
            res += root.val;
        }
        
        return res + getSum(root.left, root, parent) + getSum(root.right, root, parent);
    }
}