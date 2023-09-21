class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curr = 0;
        
        for(int i=0; i<k; i++){
            curr += nums[i];
        }
        
        int max = curr;
        
        for(int l=0, r=k; r<nums.length; l++, r++){
            curr -= nums[l];
            curr += nums[r];
            
            if(curr > max){
                max = curr;
            }
        }
        
        return 1.0 * max / k;
        
    }
}