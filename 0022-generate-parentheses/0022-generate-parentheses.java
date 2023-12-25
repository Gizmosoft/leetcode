class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        StringBuilder res = new StringBuilder();
        
        helper(res, n, 0, 0, result);
        
        return result;
        
    }
    
    public static void helper(StringBuilder res, int n, int i, int j, List<String> result) {
        // i and j are the flags to measure ( and ) respectively
        if(i == n && j == n) {
            result.add(res.toString());
        }
        
        if(i < n) { // to ensure i is bounded
            helper(res.append('('), n, i+1, j, result);
            // delete last added char - backtracking
            res.deleteCharAt(res.length()-1);
        }
        
        if( j < n && i>j) { // this is to ensure j is bounded and the closing paranthesis comes after its opening paranthesis
            helper(res.append(')'), n, i, j+1, result);
            // delete last added char - backtracking
            res.deleteCharAt(res.length()-1);
        }
    }
}