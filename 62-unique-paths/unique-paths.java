class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // for(int i=0; i<m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return recursive(m-1, n-1, dp);
        return tabulation(m, n);
    }

    // Tabulation
    private int tabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    // private int recursive(int i, int j, int[][] dp) {
    //     if(i==0 && j==0) return 1;
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int up = recursive(i-1, j, dp);
    //     int left = recursive(i, j-1, dp);
    //     dp[i][j] = up+left;
    //     return dp[i][j];
    // }
}