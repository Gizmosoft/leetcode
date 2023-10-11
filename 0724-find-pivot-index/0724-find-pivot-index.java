class Solution {
    public int pivotIndex(int[] nums) {
        
        // calculate full sum
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        
        int prevLeft = 0;
        for(int i=0; i<nums.length; i++){
            int right = sum - nums[i] - prevLeft;
            int left = sum - nums[i] - right;
            prevLeft += nums[i];
            if(left == right)
                return i;
        }
        
        return -1;
        
//         for(int i=0; i<nums.length; i++){
//             int left = 0, right = 0;
//             // calculate left sum
//             for(int j=0; j<i; j++){
//                 left += nums[j];
//             }
            
//             // calculate right sum
//             for(int j=i+1; j<nums.length; j++){
//                 right += nums[j];
//             }
            
//             // check if condition satisfies
//             if(left == right)
//                 return i;
//         }
        
//         return -1;
        
    }
}