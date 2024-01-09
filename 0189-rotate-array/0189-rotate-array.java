class Solution {
    // O(n) solution with space complexity of O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverseArr(nums, 0, n-1);   // first reverse the full array
        reverseArr(nums, 0, k-1);   // then reverse the first k elements
        reverseArr(nums, k, n-1);   // then reverse the remaining elements        
    }
    
    public void reverseArr(int[] nums, int start, int end) {
        
        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
    
//     O(n) Time solution with O(n) space
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
        
//         int[] ans = new int[n];
        
//         for(int i=0; i<n; i++) {
//             ans[(i+k)%n] = nums[i];            
//         }
        
//         for(int i=0; i<n; i++) {
//             nums[i] = ans[i];
//         }
        
//     }
}