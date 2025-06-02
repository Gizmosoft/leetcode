class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Simple Recursion
        // return Math.min(recursive(cost, n-1), recursive(cost, n-2));

        // DP Solution
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(recursiveDP(cost, n-1, dp), recursiveDP(cost, n-2, dp));
    }

    // Simple Recursion O(2^n)
    // public int recursive(int[] cost, int i) {
    //     if(i < 0) return 0;
    //     if(i == 0 || i == 1) return cost[i];

    //     return cost[i] + Math.min(recursive(cost, i-1), recursive(cost, i-2));
    // }

    public int recursiveDP(int[] cost, int i, int[] dp) {
        if(i < 0) return 0;
        if(i == 0 || i == 1) return cost[i];

        if(dp[i] != -1) return dp[i];
        dp[i] = cost[i] + Math.min(recursiveDP(cost, i-1, dp), recursiveDP(cost, i-2, dp));
        return dp[i];
    }
}