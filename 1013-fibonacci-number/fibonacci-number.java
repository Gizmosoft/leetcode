class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {
        if(n <= 0) return 0;
        if(n == 1) return 1;

        // Recursion
        // return helper(n-1) + helper(n-2);

        // Dynamic Programming
        if(dp[n] != -1) return dp[n];

        dp[n] = helper(n-1, dp) + helper(n-2, dp);
        return dp[n];
    }
}