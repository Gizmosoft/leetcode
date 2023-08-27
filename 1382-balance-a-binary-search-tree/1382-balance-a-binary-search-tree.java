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
    public List<Integer> list ;
    
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();     // stores a list of nodes in the given order
        
        inorderDfs(root);      // creates the list of tree
        
        TreeNode node = createTree(list, 0, list.size()-1);
        
        return node;        
    }
    
    public TreeNode createTree(List<Integer> list, int left, int right){
        if(left > right)
            return null;
        
        int mid = left + (right - left)/2;
        
        TreeNode root = new TreeNode(list.get(mid), createTree(list, left, mid-1), createTree(list, mid+1, right));
        
        return root;
    }
    
    public void inorderDfs(TreeNode root){
        if(root == null)
            return;
        
        inorderDfs(root.left);
        list.add(root.val);
        inorderDfs(root.right);        
    }
}