class Solution {
    public int minOperations(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int ops = 0;
        
        for(int i=0; i<nums.length-1; i++) {
            int j = i+1;
            while(nums[j] <= nums[i]){
                nums[j]++;
                ops++;
            }
        }
        
        return ops;        
    }
}