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
    public int getHeight(TreeNode node){
        if(node == null)
            return 0;
        else{
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            
            return left > right ? left+1 : right+1;
        }
    }
    
    public int getSum(TreeNode root, int height, int sum, int level){
        if(root == null)
            return 0;
        
        if(height == level){
            sum += root.val;
            return sum;
        }
        
        int left = getSum(root.left, height, sum, level + 1);
        int right = getSum(root.right, height, sum, level + 1);
        
        return left + right;     
        
    }
    
    public int deepestLeavesSum(TreeNode root) {
        
        // get max height of the tree
        
        int h = getHeight(root);
        
        int sum = getSum(root, h, 0, 1);
        
        return sum;
        
        
    }
}