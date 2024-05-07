/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    
    public void dfs(Node root, int count) {
        if(root == null) {
            return;
        }
        
        max = Math.max(max, count);
        
        if(root.children == null)
            return;
        
        for(Node child : root.children) {
            dfs(child, count+1);
        }
    }
    
    public int maxDepth(Node root) {
        dfs(root, 1);
        return max;
    }
}