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
        if(root == null) return new ArrayList<Integer>();

        Queue<TreeNode> next = new LinkedList<>();
        next.offer(root);
        Queue<TreeNode> curr = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        TreeNode node = null;
        while(!next.isEmpty()) {
            curr = next;
            next = new LinkedList<>();

            while(!curr.isEmpty()) {
                node = curr.poll();

                if(node.left != null) next.offer(node.left);
                if(node.right != null) next.offer(node.right);
            }
            res.add(node.val);
        }

        return res;        
    }
}