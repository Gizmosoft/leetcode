class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0);
    }

    public int backtrack(int[] nums, int target, int index, int total) {
        if(index >= nums.length)
            return total == target ? 1 : 0;

        return backtrack(nums, target, index+1, total+nums[index]) + backtrack(nums, target, index+1, total-nums[index]);
    }
}