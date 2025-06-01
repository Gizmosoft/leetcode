class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0; i<n; i++) {
            if(i != 0) arr1[i] = nums[i];
            if(i != n-1) arr2[i] = nums[i];
        }
        return Math.max(dp(arr1, n), dp(arr2, n));
    }

    public int dp(int[] nums, int n) {
        int prev = nums[0];
        int prev2 = 0;

        for(int i=1; i<n; i++) {
            int pickHouse = nums[i] + prev2;
            int notPickHouse = prev;
            int curr = Math.max(pickHouse, notPickHouse);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}