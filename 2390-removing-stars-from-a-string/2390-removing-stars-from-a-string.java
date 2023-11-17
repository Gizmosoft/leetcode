class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        for(Character c : stack) {
            result += c;
        }
        
        return result;
    }
}