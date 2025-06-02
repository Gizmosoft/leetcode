class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);     // Not required for tabulation approach
        if(n == 0) return 0;
        if(n == 1) return 1;
        return helper(n);
    }

    public int helper(int n) {
        // if(n <= 0) return 0;
        // if(n == 1) return 1;

        // Recursion
        // return helper(n-1) + helper(n-2);

        // Dynamic Programming
        // if(dp[n] != -1) return dp[n];
        // dp[n] = helper(n-1, dp) + helper(n-2, dp);
        // return dp[n];

        // DP with Tabulation
        // dp[0] = 0;
        // dp[1] = 1;
        // for(int i=2; i<=n; i++) {
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

        // DP with Tabulation and Space Optimization
        int prev2 = 0, prev = 1;

        for(int i=2; i<=n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}