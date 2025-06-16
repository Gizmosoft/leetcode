class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int result = recursive(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int recursive(int[] coins, int amount, int[] dp) {
        if(amount == 0) return 0;   // exact change

        if(amount < 0) {        // invalid path
            return Integer.MAX_VALUE;
        }

        if(dp[amount] != -1) return dp[amount];

        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins) {
            int count = recursive(coins, amount-coin, dp);
            if(count != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, count+1);
            }
        }
        dp[amount] = minCoins;
        return minCoins;
    } 
}