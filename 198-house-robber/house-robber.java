class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        // Arrays.fill(dp, -1);     // Not required for tabulation
        // return recursive(dp, n-1, nums);    // Call this for recursion + DP
        return recursive(dp, n, nums);        
    }

    // Recursion with DP - Top-Down approach
    // public int recursive(int[] dp, int n, int[] nums) {
    //     if(n == 0) return nums[n];

    //     if(n < 0) return 0;

    //     if(dp[n] != -1) return dp[n];

    //     int pickHouse = nums[n] + recursive(dp, n-2, nums);
    //     int notPickHouse = 0 + recursive(dp, n-1, nums);

    //     dp[n] = Math.max(pickHouse, notPickHouse);
    //     return dp[n];
    // }

    // DP with Tabulation - Bottom-up approach
    public int recursive(int[] dp, int n, int[] nums) {
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++) {
            int pickHouse = nums[i] + dp[i-2];
            int notPickHouse = dp[i-1];

            dp[i] = Math.max(pickHouse, notPickHouse);
        }
        return dp[n-1];
    }
}