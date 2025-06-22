class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursive(triangle, 0, 0, dp);
    }

    private int recursive(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if(i == triangle.size()-1) return triangle.get(i).get(j);

        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + recursive(triangle, i+1, j, dp);
        int diagonal = triangle.get(i).get(j) + recursive(triangle, i+1, j+1, dp);

        dp[i][j] = Math.min(down, diagonal);

        return dp[i][j];
    }
}