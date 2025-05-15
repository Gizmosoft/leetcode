/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // Constant Space solution
        Node a = p, b = q;
        while(a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;

        // O(n+n) time and O(n) space solution
        // Set<Node> path = findPath(p);
        // while (q.parent != null) {
        //     if(path.contains(q)) return q;
        //     q = q.parent;
        // }
        // return q;
    }

    // public Set<Node> findPath(Node p) {
    //     Set<Node> path = new HashSet<>();
    //     while(p.parent != null) {
    //         path.add(p);
    //         p = p.parent;
    //     }
    //     return path;
    // }
}