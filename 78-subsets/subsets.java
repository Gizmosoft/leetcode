class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        backtrack(0, nums, new ArrayList<>(), ans, n);
        return ans;       
    }

    public void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> ans, int n) {
        if(i >= n) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i+1, nums, subset, ans, n);

        subset.remove(subset.size()-1);
        backtrack(i+1, nums, subset, ans, n);
    }
}