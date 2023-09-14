class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] answer = new int[n];
        int pre = 1, post = 1;
        
        for(int i=0; i<n; i++){
            answer[i] = pre;
            pre = pre*nums[i];
        }
        
        for(int i=n-1; i>=0; i--){
            answer[i] = answer[i] * post;
            post = post * nums[i];
        }
        
        return answer;
    }
}