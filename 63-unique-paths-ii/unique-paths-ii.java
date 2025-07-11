class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // int[][] dp = new int[m][n];
        // for(int i=0; i<m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return recursive(obstacleGrid, m-1, n-1, dp);
        return tabulation(obstacleGrid, m, n);
    }

    private int tabulation(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    // private int recursive(int[][] grid, int i, int j, int[][] dp) {
    //     if(i>=0 && j>=0 && grid[i][j] == 1) return 0;
    //     if(i == 0 && j == 0) return 1;
    //     if(i < 0 || j < 0) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     int up = recursive(grid, i-1, j, dp);
    //     int left = recursive(grid, i, j-1, dp);

    //     dp[i][j] = up+left;

    //     return dp[i][j];
    // }
}