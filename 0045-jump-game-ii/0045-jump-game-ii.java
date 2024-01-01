class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int answer = 0; // keeps a track of the jumps
        
        while(r < n-1){
            int farthest = 0;   // how far we can jump
            for(int i=l; i<=r; i++) {
                farthest = Math.max(farthest, i+nums[i]);   // compute the farthest we can jump from the current point
            }
            // update left and right pointers 
            l = r+1;    // left will go one beyond the current window
            r = farthest;   // right will moved to the max farthest computed above
            // increment the answer
            answer++;
        }
        
        return answer;       
    }
}