class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        TreeSet<Integer>[] graph = new TreeSet[n];
        Map<TreeSet<Integer>, Integer> componentFreq = new HashMap<>();

        // initialize adjacency lists
        for(int i=0; i<n; i++) {
            graph[i] = new TreeSet<>();
            graph[i].add(i);
        }

        // build adj list
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // count freq
        for(int i=0; i<n; i++) {
            TreeSet<Integer> neighbors = graph[i];
            componentFreq.put(neighbors, componentFreq.getOrDefault(neighbors, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<TreeSet<Integer>, Integer> entry : componentFreq.entrySet()) {
            if(entry.getKey().size() == entry.getValue()) count++;
        }

        return count;
    }
}