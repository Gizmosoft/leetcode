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
//         0ms --> checks only the possible nodes
    int sum = 0;
    
    public void traverse(TreeNode root, int low, int high){
        if(root == null)
            return;
        
        if(root.val < low){
            traverse(root.right, low, high);
        }
        else if(root.val > high){
            traverse(root.left, low, high);
        }
        else{
            sum += root.val;
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        }
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        
        traverse(root, low, high);
        return sum;
        
//         1ms --> traverses full BST O(n)
//         if(root == null)
//             return 0;
        
//         int sum = 0;
        
//         if(root.val >= low && root.val <= high){
//             sum += root.val;
//         }
        
//         sum += rangeSumBST(root.left, low, high);
//         sum += rangeSumBST(root.right, low, high);
        
//         return sum;       
    }
}