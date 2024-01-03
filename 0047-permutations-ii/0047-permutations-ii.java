class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Set<List<Integer>> answer = new HashSet<>();
        
        helper(nums, nums.length, 0, answer);
        List<List<Integer>> result = new ArrayList<>(answer);
        return result;        
    }
    
    public void helper(int[] nums, int n, int index, Set<List<Integer>> answer) {
        if(index == n) {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++) list.add(nums[i]);
            answer.add(list);
            return;
        }
        
        for(int i=index; i<n; i++) {
            swap(nums, i, index);
            helper(nums, n, index+1, answer);
            swap(nums, i, index);
        }
    }
    
    public void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}