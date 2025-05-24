class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, new ArrayList<>(), res, 1);
        return res;
    }

    public void backtrack(int k, int n, List<Integer> sum, List<List<Integer>> res, int start) {
        if(n==0 && sum.size()==k) {
            res.add(new ArrayList<>(sum));
            return;
        } else if(n < 0 && sum.size()==k) return;

        for(int i=start; i<=9; i++) {
            sum.add(i);
            backtrack(k, n-i, sum, res, i+1);
            sum.removeLast();
        }
    }
}