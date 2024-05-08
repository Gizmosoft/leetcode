class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>()); // Initialize each index with a new HashSet
        }
        
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            // update neighbors in the adjList
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        return dfs(source, destination, visited, adjList);
        
    }
    
    public boolean dfs(int source, int destination, boolean[] visited, List<Set<Integer>> adjList) {
        if(source == destination)
            return true;
        visited[source] = true;     // mark source node as visited
        
        for(Integer neighbor: adjList.get(source)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, destination, visited, adjList))
                    return true;
            }
        }
        return false;        
    }
}