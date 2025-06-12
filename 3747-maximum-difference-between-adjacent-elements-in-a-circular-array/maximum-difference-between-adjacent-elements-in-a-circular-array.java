class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int difference = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int j=i+1;
            if(j==nums.length) j = 0;
            difference = Math.max(difference, diff(nums[i], nums[j]));
        }
        return difference;
    }

    private int diff(int a, int b) {
        return Math.abs(a-b);
    }
}