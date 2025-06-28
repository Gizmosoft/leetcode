class Solution {
    public int findPeakElement(int[] nums) {
        // O(logn)
        int n = nums.length;
        int left = 0, right = n-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;

        // O(n)
        // int n = nums.length;

        // if(n==1) return 0;
        // if(nums[0] > nums[1]) return 0;

        // for(int i=1; i<n-1; i++) {
        //     if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
        //         return i;
        // }

        // if(nums[n-1] > nums[n-2])
        //     return n-1;
        // return -1;
    }
}