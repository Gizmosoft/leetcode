class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        
        while(end >= start) {
            int mid = start + (int)Math.floor((end-start+1)/2);
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target){
                // shift to bigger half
                start = mid+1;
            } else if(nums[mid] > target) {
                end = mid-1;
            }
        }
        
        return -1;
        
    }
}