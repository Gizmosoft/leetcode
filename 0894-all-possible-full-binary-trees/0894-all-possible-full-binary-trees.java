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
    // more optimized solution
    HashMap<Integer, List<TreeNode>> map;
        
        Solution(){
            this.map = new HashMap<Integer, List<TreeNode>>();
            map.put(0, new ArrayList<TreeNode>());
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(new TreeNode(0));
            map.put(1, list);
        }
    
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0)
            return map.get(0);
        
        if(map.containsKey(n))
            return map.get(n);
        
        List<TreeNode> answer = new ArrayList<TreeNode>();
        
        for(int l=0; l<n; l++){
            int r = n - 1 -l;
            
            List<TreeNode> leftSub = allPossibleFBT(l);
            List<TreeNode> rightSub = allPossibleFBT(r);
            
            for(TreeNode tree1 : leftSub){
                for(TreeNode tree2 : rightSub){
                    TreeNode tree = new TreeNode(0, tree1, tree2);
                    answer.add(tree);
                }
            }
        }
        map.put(n, answer);
        return answer;
               
//         List<TreeNode> result = new ArrayList<>();
        
//         if(n%2 == 0){
//             return result;
//         }
        
//         if(n == 1){
//             result.add(new TreeNode(0));
//             return result;
//         }
        
        
//         for(int i=1; i<n; i+=2){
            
//             List<TreeNode> left = allPossibleFBT(i);
//             List<TreeNode> right = allPossibleFBT(n-i-1);
            
//             for(TreeNode l : left){
//                 for(TreeNode r : right){
//                     TreeNode root = new TreeNode(0);
//                     root.left = l;
//                     root.right = r;
//                     result.add(root);
//                 }
//             }
//         }
        
//         return result;
        
        
    }
    
}