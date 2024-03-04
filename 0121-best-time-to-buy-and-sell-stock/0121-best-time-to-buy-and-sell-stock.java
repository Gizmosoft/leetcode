class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        
        for(int i=1; i<prices.length; i++) {
            if(buy < prices[i]) {
                profit = Math.max(profit, prices[i]-buy);
            } else {
                buy = prices[i];
            }
        }
        return profit;        
    }
}


/*
    max = MIN
    min = MAX
    profit = 0
    
    -> 7
    is (7 < min) yes: min = 7
    is (1 > max) yes: max = 1
    is (max-min > profit) no:
    
    -> 1
    ? 1 < min : min = 1
    ? 5 > max : max = 5
    max-min = 4 : 4 > profit : profit = 4
    
    -> 5
    ? 5 < min - no: min = 1
    ? 3 > max - no: max = 5
    profit = 4
    
    -> 3
    ? 3 < min min = 1
    ? 6 > max max = 6
    profit = 5 > 4 = profit = 5


*/