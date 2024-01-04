class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), answer);
        return answer;
    }
    
    public void backtrack(int start, int[] nums, List<Integer> list, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++) {
            // add the i'th element to list
            list.add(nums[i]);
            // call the function recursively for the next i
            backtrack(i+1, nums, list, answer);
            // backtrack by removing the last element in the list
            list.remove(list.size()-1);
        }
    }
}