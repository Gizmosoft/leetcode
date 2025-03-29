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
    public List<Integer> rightSideView(TreeNode root) {
        // One Queue + getting rightmost element
        if(root == null) return new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        List<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()) {
            int level = queue.size();

            for(int i=0; i<level; i++) {
                TreeNode node = queue.poll();

                if(i == level-1) {
                    res.add(node.val);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return res;

        // BFS using 2 Queues
        // if(root == null) return new ArrayList<Integer>();

        // Queue<TreeNode> next = new LinkedList<>();
        // next.offer(root);
        // Queue<TreeNode> curr = new LinkedList<>();
        // List<Integer> res = new ArrayList<>();

        // TreeNode node = null;
        // while(!next.isEmpty()) {
        //     curr = next;
        //     next = new LinkedList<>();

        //     while(!curr.isEmpty()) {
        //         node = curr.poll();

        //         if(node.left != null) next.offer(node.left);
        //         if(node.right != null) next.offer(node.right);
        //     }
        //     res.add(node.val);
        // }

        // return res;        
    }
}