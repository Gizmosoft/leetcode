class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        
        int jumps = n/3;
        Arrays.sort(piles);
        int sum = 0;
        int i = n-2;
        while(jumps > 0) {
            sum += piles[i];
            jumps--;
            i = i-2;
        }
        
        return sum;
    }
}