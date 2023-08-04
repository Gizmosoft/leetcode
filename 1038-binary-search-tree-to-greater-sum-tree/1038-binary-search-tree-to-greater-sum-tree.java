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
    int currSum = 0;    // global var
    public TreeNode bstToGst(TreeNode root) {
        
        dfs(root);
        
        return root;       
    }
    
    public void dfs(TreeNode currNode){     // this method will update all the nodes of the tree
        if(currNode == null)
            return;
        
        dfs(currNode.right);     // traverse right first as that sub tree will always be greater than the node
        int temp = currNode.val; // store current node value in temp
        currNode.val += currSum; // add currSum to the current node value
        currSum += temp;         // add the node value stored in temp to the sum;
        dfs(currNode.left);      // then check left subtree
    }
}