class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> cache = new HashMap<>();
        int n = grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                cache.put(grid[i][j], cache.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        int[] result = new int[2];
        for(int i=1; i<=n*n; i++) {
            int mapVal = cache.getOrDefault(i, 0);
            if(mapVal == 2)
                result[0] = i;
            else if(mapVal == 0)
                result[1] = i;
        }

        return result;
    }
}