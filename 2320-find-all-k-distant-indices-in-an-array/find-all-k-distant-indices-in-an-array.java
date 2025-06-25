class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        for(int j=0; j<n; j++) {
            if(nums[j] == key) {
                int left = (j-k < 0) ? 0 : j-k;
                int right = (j+k >=n) ? n-1 : j+k;

                for(int i=left; i<=right; i++) {
                    if(Math.abs(i-j) <= k) {
                        if(dp[i] != -1) continue;
                        else {
                            dp[i] = i;
                            res.add(i);
                        }
                    }
                }
            }
        }
        return res;
    }
}