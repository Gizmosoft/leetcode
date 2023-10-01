class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int flag = 1;
        int n = nums.length;
        int max = 0;
        
        while(right < n){
            if(nums[right] == 0){
                flag--;
            }
            
            if(flag < 0){
                if(nums[left] == 0){
                    flag++;
                }
                left++;
            }
            right++;
            max = Math.max(max, right-left-1);          
        }
        
        return max;
    }
}