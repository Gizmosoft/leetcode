class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int l = 0, r = 1;
        
        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                profit += prices[r]-prices[l];
            }
            l++;
            r++;
        }        
        return profit;        
    }
}