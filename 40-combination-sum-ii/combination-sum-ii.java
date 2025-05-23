class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int start, List<Integer> sum, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(sum));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;     // remove duplicates

            if(candidates[i] > target) break;
            sum.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, sum, ans);
            sum.remove(sum.size()-1);
        }  
    }
}