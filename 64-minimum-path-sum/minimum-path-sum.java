class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int[][] dp = new int[m][n];
        // for(int i=0; i<m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return recursive(grid, m-1, n-1, dp);
        // return tabulation(grid, m, n);
        return spaceOpt(grid, m, n);
    }

    private int spaceOpt(int[][] grid, int m, int n) {
        int[] prev = new int[m];
        for(int i=0; i<m; i++) {
            int[] curr = new int[n];
            for(int j=0; j<n; j++) {
                if(i==0 && j==0)
                    curr[j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    if(i>0)
                        up += prev[j];
                    else
                        up += (int) Math.pow(10, 7);
                    
                    int left = grid[i][j];
                    if(j>0)
                        left += curr[j-1];
                    else
                        left += (int) Math.pow(10, 7);
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }

    // private int tabulation(int[][] grid, int m, int n) {
    //     int[][] dp = new int[m][n];

    //     for(int i=0; i<m; i++) {
    //         for(int j=0; j<n; j++) {
    //             if(i==0 && j==0) dp[i][j] = grid[i][j];
    //             else {
    //                 int up = grid[i][j], left = grid[i][j];
    //                 if(i>0) up += dp[i-1][j];
    //                 else up += 10000000;

    //                 if(j>0) left += dp[i][j-1];
    //                 else left += 10000000;
    //                 dp[i][j] = Math.min(up, left);
    //             }
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }

    // private int recursive(int[][] grid, int i, int j, int[][] dp) {
    //     if(i == 0 && j == 0) return grid[i][j];
    //     if(i<0 || j<0) return 10000000;

    //     if(dp[i][j] != -1) return dp[i][j];
    //     int up = grid[i][j] + recursive(grid, i-1, j, dp);
    //     int left = grid[i][j] + recursive(grid, i, j-1, dp);
    //     dp[i][j] = Math.min(up, left);
    //     return dp[i][j];
    // }
}