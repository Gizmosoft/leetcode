class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Simple Recursion
        // return Math.min(recursive(cost, n-1), recursive(cost, n-2));

        // DP Solution
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);     // Only needed for DP
        // return Math.min(recursiveDP(cost, n-1, dp), recursiveDP(cost, n-2, dp));

        // DP with Tabulation
        // int[] dp = new int[n];
        // return dpTabulation(cost, dp, n);

        // Tabulation w/ Space Optimization 
        return tabulationSpaceOpt(cost, n);
    }

    // Simple Recursion O(2^n)
    // public int recursive(int[] cost, int i) {
    //     if(i < 0) return 0;
    //     if(i == 0 || i == 1) return cost[i];

    //     return cost[i] + Math.min(recursive(cost, i-1), recursive(cost, i-2));
    // }

    // Dynamic Programming O(n)
    // public int recursiveDP(int[] cost, int i, int[] dp) {
    //     if(i < 0) return 0;
    //     if(i == 0 || i == 1) return cost[i];

    //     if(dp[i] != -1) return dp[i];
    //     dp[i] = cost[i] + Math.min(recursiveDP(cost, i-1, dp), recursiveDP(cost, i-2, dp));
    //     return dp[i];
    // }

    // Dynamic Programming with Tabulation
    // public int dpTabulation(int[] cost, int[] dp, int n) {
    //     dp[0] = cost[0];
    //     dp[1] = cost[1];

    //     for(int i=2; i<n; i++) {
    //         dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    //     }

    //     return Math.min(dp[n-1], dp[n-2]);
    // }

    // Tabulation with Space Optimization
    public int tabulationSpaceOpt(int[] cost, int n) {
        int prev2 = cost[0];
        int prev = cost[1];

        for(int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(prev2, prev);
            prev2 = prev;
            prev = curr;
        }

        return Math.min(prev2, prev);
    }
}