class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int flag = k;
        int maxCount = 0;
        int n = nums.length;
        
        while(right < n){
            if(nums[right] == 0){
                if(flag == 0){
                    while(nums[left] == 1){
                        left++;
                    }
                    left++;
                }
                else{
                    flag--;
                }
            }
            maxCount = Math.max(maxCount, right-left+1);
            right++;
        }
        
        
        return maxCount;
    }
}