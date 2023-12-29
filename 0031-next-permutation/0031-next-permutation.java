class Solution {
    public void nextPermutation(int[] nums) {
        
        // Check if the array is strictly decreasing
        // if yes then reverse the whole array and that's our answer
        // if no, then there is an index where the decreasing order breaks, i.e. arr[i] < arr[i+1]
        // in that case, find that pivot index where the decreasing order breaks 
        // and from the right most end of the array, find the smallest number that is greater than the pivot and swap it
        // now reverse the subarray from index+1th array and the end of the array
        // the resultant array is our answer
        
        int index = -1;     // flag to keep a track of pivot
        int n = nums.length;
        for(int i=n-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                index = i;
                break;
            }
        }
        
        if(index == -1) {
            reverse(nums, 0, n-1);
        }
        else {
            for(int i=n-1; i>index; i--) {
                if(nums[i] > nums[index]) {
                    nums[index] += nums[i];
                    nums[i] = nums[index] - nums[i];
                    nums[index] -= nums[i];
                    break;
                }
            }
            reverse(nums, index+1, n-1);
        }
    }
    
    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            nums[start] += nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] -= nums[end];
            start++;
            end--;
        }        
    }
}