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
    private PriorityQueue<Integer> pq;
    public int kthSmallest(TreeNode root, int k) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        helper(root, k, pq);
        return pq.poll();        
    }

    private void helper(TreeNode node, int k, PriorityQueue<Integer> pq) {
        if(node == null) return;

        helper(node.left, k, pq);
        pq.add(node.val);
        if(pq.size() > k) {
            pq.poll();
            return;
        }
        helper(node.right, k, pq);
        return;
    } 
}