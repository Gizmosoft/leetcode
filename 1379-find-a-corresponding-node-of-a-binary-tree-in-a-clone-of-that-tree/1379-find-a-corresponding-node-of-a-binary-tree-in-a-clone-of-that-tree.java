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
    public TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        dfs(original, cloned, target);
        
        return res;        
    }
    
    private void dfs(TreeNode original, TreeNode cloned, TreeNode target){
        if(original == null) return;
        
        if(original == target){
            this.res = cloned;
            return;
        }
        
        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
    }
}