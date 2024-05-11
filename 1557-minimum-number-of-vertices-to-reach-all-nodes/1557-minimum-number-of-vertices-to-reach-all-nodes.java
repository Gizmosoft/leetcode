class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] hasIncoming = new boolean[n];
        
        // update which graph index has no incoming edges which marks the root node
        for(int i=0; i<edges.size(); i++) {
            hasIncoming[edges.get(i).get(1)] = true;
        }
        
        for(int i=0; i<n; i++) {
            if(!hasIncoming[i]) {
                res.add(i);
            }
        }
        
        return res;
    }
}