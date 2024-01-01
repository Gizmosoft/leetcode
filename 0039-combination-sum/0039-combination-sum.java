class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(0, candidates, new ArrayList<>(), target, answer);
        return answer;
    }
    
    public static void helper(int start, int[] candidates, List<Integer> list, int target, List<List<Integer>> answer) {
        if(target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=start; i<candidates.length; i++) {
            if(candidates[i] <= target) {
                list.add(candidates[i]);
                helper(i, candidates, list, target-candidates[i], answer);
                list.remove(list.size()-1);
            }
        }
    }
}