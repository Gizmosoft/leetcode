class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                provinces++;
                // dfs(i, isConnected, visited);
                bfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    // private void dfs(int node, int[][] isConnected, boolean[] visited) {
    //     visited[node] = true;
    //     for(int i=0; i<isConnected.length; i++) {
    //         if(isConnected[node][i] == 1 && !visited[i]) {
    //             dfs(i, isConnected, visited);
    //         }
    //     }
    // }

    private void bfs(int node, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            node = q.poll();

            for(int i=0; i<isConnected.length; i++) {
                if(isConnected[node][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}