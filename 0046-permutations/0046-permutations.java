class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        helper(nums, answer, 0, nums.length);
        return answer;
        
    }
    
    public void helper(int[] nums, List<List<Integer>> answer, int index, int n) {
        if(index == n) {
            List<Integer> list = new ArrayList<>();
            // if index reaches n, then add the current array to a list and add that list to answer
            for(int i=0; i<n; i++) {
                list.add(nums[i]);
            }
            answer.add(list);
            return;
        }
        
        for(int i=index; i<n; i++) {
            swap(nums, i, index);
            helper(nums, answer, index+1, n);
            swap(nums, i, index);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}