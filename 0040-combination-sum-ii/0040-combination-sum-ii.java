class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(target, 0, 0, new ArrayList<>(), candidates, answer);
        
        return answer;
    }
    
    public void backtracking(int target, int start, int sum, List<Integer> list, int[] candidates, List<List<Integer>> answer){
        if(sum == target) {
            answer.add(new ArrayList<Integer>(list));
            return;
        }
        
        int lastRemoved = 0;
        for(int i=start; i<candidates.length; i++) {
            if(sum + candidates[i] > target) return;
            if(candidates[i] == lastRemoved) continue;
            list.add(candidates[i]);
            backtracking(target, i+1, sum + candidates[i], list, candidates, answer);
            lastRemoved = list.remove(list.size()-1);
        }
    }
}