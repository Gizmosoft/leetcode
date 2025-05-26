class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return helper(dp, n);
        // int one = 1, two = 1;
        // for(int i=0; i<n-1; i++) {
        //     int temp = one;
        //     one = one + two;
        //     two = temp;
        // }
        // return one;        
    }

    public int helper(int[] dp, int n) {
        if(n == 0 || n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        dp[n] = helper(dp, n-1) + helper(dp, n-2);
        return dp[n];
    }
}