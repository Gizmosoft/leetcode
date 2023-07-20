class Solution {
    public boolean isValid(String s) {
        String openBrackets = "([{";
        
        Map<Character, Character> key = new HashMap<>();
        key.put(')', '(');
        key.put('}', '{');
        key.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(openBrackets.indexOf(s.charAt(i)) != -1){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.isEmpty() && stack.peek() == key.get(s.charAt(i))){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        if(!stack.isEmpty())
            return false;
        else
            return true;
        
    }
}