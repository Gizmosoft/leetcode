class Solution {
    public int pivotIndex(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            int left = 0, right = 0;
            // calculate left sum
            for(int j=0; j<i; j++){
                left += nums[j];
            }
            
            // calculate right sum
            for(int j=i+1; j<nums.length; j++){
                right += nums[j];
            }
            
            // check if condition satisfies
            if(left == right)
                return i;
        }
        
        return -1;
        
    }
}