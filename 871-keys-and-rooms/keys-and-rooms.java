class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, res, visited);
        if(res.size() == rooms.size())
            return true;
        return false;
    }

    public static void dfs(List<List<Integer>> rooms, int source, List<Integer> res, boolean[] visited) {
        visited[source] = true;
        res.add(source);

        for(int neighbour: rooms.get(source)) {
            if(!visited[neighbour]) {
                dfs(rooms, neighbour, res, visited);
            }
        }
    }
}