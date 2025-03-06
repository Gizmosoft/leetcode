class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int pairs = 0;
        int right = n-1;
        int left = 0;

        // Optimization
        while(left < right) {
            if(nums.get(left) + nums.get(right) < target) {
                pairs += right - left;  // if the pair having largest gap b/w them is lesser than target then all pairs in b/w will also sum up to be smaller than target
                left++; // move to the next left pointer as all pairs for the current have been added to solution
            } else {
                right--;
            }
        }

        // for(int i=0; i<n; i++) {
        //     int right = n-1;
        //     while(right > i) {
        //         if(nums.get(i) + nums.get(right) < target){
        //             pairs++;
        //         }
        //         right--;
        //     }
        // }
        return pairs;
    }
}