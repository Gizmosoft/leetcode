class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        
        int left = 0, right = n-1;
        int l = -1, r = -1;
        ans[0] = l;
        ans[1] = r;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] == target) {
                // do something
                l = mid;
                r = mid;
                ans[0] = l;
                ans[1] = r;
                // System.out.println("l:" + l + ", r:" + r);
                while(r < n){
                    if(nums[r] == target) {
                        r++;
                    }
                    else{
                        // ans[1] = r-1;
                        break;
                    }
                    ans[1] = r-1;
                }
                
                while(l >= 0) {
                    if(nums[l] == target){
                        l--;
                    }
                    else{
                        // ans[0] = l+1;
                        break;
                    }
                    ans[0] = l+1;
                } 
            }
            
            if(nums[mid] < target) {
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        
        return ans;
        
    }
}