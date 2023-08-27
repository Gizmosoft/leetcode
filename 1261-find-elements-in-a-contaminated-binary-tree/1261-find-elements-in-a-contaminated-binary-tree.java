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
class FindElements {
    
    private Set<Integer> set;   // to store elements of the node

    public FindElements(TreeNode root) {
        // init the set
        set = new HashSet<>();
        dfs(root, 0);               
    }
    
    public boolean find(int target) {
        return set.contains(target);
        
    }
    
    private void dfs(TreeNode root, int x){
        if(root == null)
            return;
        
        set.add(x);
        
        dfs(root.left, 2 * x + 1);
        dfs(root.right, 2 * x + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */