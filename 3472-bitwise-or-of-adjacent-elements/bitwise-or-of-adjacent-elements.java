class Solution {
    public int[] orArray(int[] nums) {
        int[] ans = new int[nums.length-1];

        for(int i=0; i<nums.length-1; i++) {
            int orRes = nums[i] | nums[i+1];
            ans[i] = orRes;
        }
        return ans;
    }
}