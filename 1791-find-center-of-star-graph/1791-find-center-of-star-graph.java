class Solution {
//     SOLUTION 1 - O(n) but slower
//     public int findCenter(int[][] edges) {
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for(int[] edge: edges) {
//             map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
//             map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
//         }
//         int center = 0;
        
//         for (Integer key : map.keySet()) {
//             if (map.get(key) == edges.length) return key;
//         }
//         return 0;     
//     }
    
//     SOLUTION 2: O(1)
    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        
        for(int[] edge: edges) {
            if(set.contains(edge[0])) return edge[0];
            else if(set.contains(edge[1])) return edge[1];
            
            set.add(edge[0]);
            set.add(edge[1]);
        }
        return 0;
    }
}