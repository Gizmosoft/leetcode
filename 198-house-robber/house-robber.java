class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursive(dp, n-1, nums);        
    }

    public int recursive(int[] dp, int n, int[] nums) {
        if(n == 0) return nums[n];

        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        int pickHouse = nums[n] + recursive(dp, n-2, nums);
        int notPickHouse = 0 + recursive(dp, n-1, nums);

        dp[n] = Math.max(pickHouse, notPickHouse);
        return dp[n];
    }
}