class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int[][] dp = new int[matrix.length][matrix[0].length];
        // for(int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // for(int j=0; j<matrix[0].length; j++) {
        //     minVal = Math.min(minVal, recursive(matrix, matrix.length-1, j, dp));
        // }
        // return minVal;
        return tabulation(matrix);
    }

    private int tabulation(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int j=0; j<n; j++) dp[0][j] = matrix[0][j];

        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                int up = matrix[i][j] + dp[i-1][j];

                int left = matrix[i][j];
                if(j-1 >= 0) left += dp[i-1][j-1];
                else left += (int) Math.pow(10, 7);

                int right = matrix[i][j];
                if(j+1 < n) right += dp[i-1][j+1];
                else right += (int) Math.pow(10, 7);

                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }

        int minVal = (int) Math.pow(10, 7);
        for(int j=0; j<n; j++) {
            minVal = Math.min(minVal, dp[m-1][j]);
        }
        return minVal;
    }

    private int recursive(int[][] matrix, int i, int j, int[][] dp) {
        if(j<0 || j>=matrix[0].length) return (int) Math.pow(10, 7);
        if(i==0) return matrix[0][j];

        if(dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + recursive(matrix, i-1, j, dp);
        int left = matrix[i][j] + recursive(matrix, i-1, j-1, dp);
        int right = matrix[i][j] + recursive(matrix, i-1, j+1, dp);

        dp[i][j] = Math.min(up, Math.min(left, right));
        return dp[i][j];
    }
}