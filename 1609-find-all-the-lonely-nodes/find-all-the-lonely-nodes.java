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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        dfs(root, answer);
        return answer;
    }

    private void dfs(TreeNode node, List<Integer> answer) {
        if(node == null) return;

        if( (node.left == null && node.right != null) ) {
            answer.add(node.right.val);
        }
        if( (node.left != null && node.right == null) ) {
            answer.add(node.left.val);
        }

        dfs(node.left, answer);
        dfs(node.right, answer);
    }
}