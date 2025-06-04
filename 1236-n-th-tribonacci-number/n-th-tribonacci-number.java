class Solution {
    public int tribonacci(int n) {
        // return recursive(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dpSol(n, dp);
    }

    // RECURSION 
    // public int recursive(int n) {
    //     if(n <= 0) return 0;
    //     if(n == 1 || n == 2) return 1;

    //     return recursive(n-1) + recursive(n-2) + recursive(n-3);
    // }

    // DP Solution
    public int dpSol(int n, int[] dp) {
        if(n <= 0) return 0;
        if(n == 1 || n == 2) return 1;

        if(dp[n] != -1) return dp[n];
        dp[n] = dpSol(n-1, dp) + dpSol(n-2, dp) + dpSol(n-3, dp);
        return dp[n];
    }
}