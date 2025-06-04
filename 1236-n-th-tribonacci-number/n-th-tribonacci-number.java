class Solution {
    public int tribonacci(int n) {
        // return recursive(n);
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return dpSol(n, dp);

        if(n == 0) return 0;
        if(n == 2 || n == 1) return 1;
        // return dpWithTab(n, dp);
        return TabWithSpace(n);
    }

    // RECURSION 
    // public int recursive(int n) {
    //     if(n <= 0) return 0;
    //     if(n == 1 || n == 2) return 1;

    //     return recursive(n-1) + recursive(n-2) + recursive(n-3);
    // }

    // DP Solution
    // public int dpSol(int n, int[] dp) {
    //     if(n <= 0) return 0;
    //     if(n == 1 || n == 2) return 1;

    //     if(dp[n] != -1) return dp[n];
    //     dp[n] = dpSol(n-1, dp) + dpSol(n-2, dp) + dpSol(n-3, dp);
    //     return dp[n];
    // }

    // DP with Tabulation
    // public int dpWithTab(int n, int[] dp) {
    //     dp[0] = 0;
    //     dp[1] = 1;
    //     dp[2] = 1;

    //     for(int i=3; i<=n; i++) {
    //         dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    //     }
    //     return dp[n];
    // }

    // Tabulation with Space Optimization
    public int TabWithSpace(int n) {
        int prev3 = 0, prev2 = 1, prev = 1;

        for(int i=3; i<=n; i++) {
            int curr = prev3 + prev2 + prev;
            prev3 = prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}