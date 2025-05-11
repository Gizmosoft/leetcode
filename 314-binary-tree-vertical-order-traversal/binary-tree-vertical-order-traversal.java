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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, List<Integer>> columnTable = new HashMap<>();  // hashmap to store column no. and list of node val in that col
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();  // Pair of node and its corresponding column no. stored in queue
        int column = 0;
        queue.offer(new Pair(root, column));    // fill queue with the root node and its column value
        int minCol = 0, maxCol = 0;

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if(root != null) {
                if(!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<>());
                }
                columnTable.get(column).add(root.val);
                minCol = Math.min(minCol, column);
                maxCol = Math.max(maxCol, column);

                queue.offer(new Pair(root.left, column-1));
                queue.offer(new Pair(root.right, column+1));
            }
        }

        for(int i=minCol; i<=maxCol; i++) {
            ans.add(columnTable.get(i));
        }

        return ans;
    }
}