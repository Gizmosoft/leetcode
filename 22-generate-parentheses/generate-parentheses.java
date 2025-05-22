class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    public void backtrack(int n, int open, int closed, StringBuilder s, List<String> answer) {
        if(open == n && closed == n) {
            answer.add(s.toString());
            return;
        }

        if(open < n) {
            s.append("(");
            backtrack(n, open+1, closed, s, answer);
            s.deleteCharAt(s.length()-1);
        }

        if(closed < open) {
            s.append(")");
            backtrack(n, open, closed+1, s, answer);
            s.deleteCharAt(s.length()-1);
        }
    }
}