class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int start, List<Integer> sum, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(sum));
            return;
        }

        if(target < 0) return;

        for(int i=start; i<candidates.length; i++) {
            sum.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, sum, ans);
            sum.remove(sum.size()-1);
        }
    }
}