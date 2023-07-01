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

import java.util.*;

class Solution {
    private int count = 0;
    
    public int averageOfSubtree(TreeNode root) {
        getAverage(root);
        return count;
    }
    
    public int[] getAverage(TreeNode root){
        if(root == null){ 
            int[] arr = {0, 0};
            return arr;
        }
        
        int[] left = getAverage(root.left);
        int[] right = getAverage(root.right);
        
        int sum = root.val + left[0] + right[0];
        int nodes = 1 + left[1] + right[1];
        if(root.val == sum/nodes)
            count++;
        
        return new int[]{sum, nodes};
        
    }
}