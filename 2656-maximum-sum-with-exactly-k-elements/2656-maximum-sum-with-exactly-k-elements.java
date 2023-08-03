class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int sum = nums[n-1];
        int key = sum;
        
        for(int i=1; i<k; i++){
            sum += key+i;
        }
        
        return sum;
                
    }
}