class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> combo, List<List<Integer>> res) {
        res.add(new ArrayList<>(combo));

        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i] == nums[i-1]) continue;

            combo.add(nums[i]);
            backtrack(nums, i+1, combo, res);
            combo.remove(combo.size()-1);
        }
    }
}