class Solution {
    public List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int source = 0, destination = n-1;
        
        dfs(source, destination, graph, new ArrayList<>());
        
        return answer;        
    }
    
    public void dfs(int source, int destination, int[][] graph, List<Integer> list) {
        list.add(source);
        if(source == destination){
            answer.add(new ArrayList<>(list));
        } else {
            for(int neighbor: graph[source]) {
                dfs(neighbor, destination, graph, list);
                list.remove(list.size()-1);         // backtrack
            }
        }   
    }
}