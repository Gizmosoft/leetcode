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
    public List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        bfs(root);
        
        return list;
        
    }
    
    private Queue<TreeNode> q;
    
    
    public void bfs(TreeNode root){
        q = new LinkedList<>();     // init the queue
        q.add(root);                // add the root node to queue
        q.add(null);                // null as a breakpoint to indicate level end
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> front = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp == null)    break;      // ignore the breakpoints
                
                if(temp.left != null){          // left node
                    q.add(temp.left);
                }

                if(temp.right != null){         // right node
                    q.add(temp.right);
                }
                
                front.add(temp.val);
                
            }
            
            list.add(front);
            
            if(!q.isEmpty())
                q.add(null);
        }
    }
}