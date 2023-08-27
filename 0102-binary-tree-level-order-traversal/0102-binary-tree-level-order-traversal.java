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
//         DFS Call
        return dfs(root, 0);
        
//         BFS Function Call
//         if(root == null){
//             return new ArrayList<>();
//         }
        
//         bfs(root);
        
//         return list;
        
    }
    
//     DFS Method
    public List<List<Integer>> dfs(TreeNode root, int level){
        if(root == null)
            return list;
        
        if(list.size() == level)
            list.add(new ArrayList<>());
        
        list.get(level).add(root.val);
        // call left and right sub tree recursively
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
        return list;
    }
    
//     BFS - Level Order Traversal
//     private Queue<TreeNode> q;
    
    
//     public void bfs(TreeNode root){
//         q = new LinkedList<>();     // init the queue
//         q.add(root);                // add the root node to queue
//         q.add(null);                // null as a breakpoint to indicate level end
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> front = new ArrayList<>();
            
//             for(int i=0; i<size; i++){
//                 TreeNode temp = q.poll();
//                 if(temp == null)    break;      // ignore the breakpoints
                
//                 if(temp.left != null){          // left node
//                     q.add(temp.left);
//                 }

//                 if(temp.right != null){         // right node
//                     q.add(temp.right);
//                 }
                
//                 front.add(temp.val);
                
//             }
            
//             list.add(front);
            
//             if(!q.isEmpty())
//                 q.add(null);
//         }
//     }
}