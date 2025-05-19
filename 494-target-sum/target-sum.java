class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();     // dp { (index,total), sum } -> tracks total number of ways to get to the target for each index,total combo
        return backtrack(nums, target, dp, 0, 0);
    }

    public int backtrack(int[] nums, int target, Map<String, Integer> dp, int index, int total) {
        if(index >= nums.length)
            return total == target ? 1 : 0;

        String key = index + "," + total;
        if(dp.containsKey(key))
            return dp.get(key);     // return the total sum for the current key   

        int add = backtrack(nums, target, dp, index+1, total+nums[index]);
        int subtract = backtrack(nums, target, dp, index+1, total-nums[index]);
        dp.put(key, add + subtract);
        return add + subtract; 
    }
}