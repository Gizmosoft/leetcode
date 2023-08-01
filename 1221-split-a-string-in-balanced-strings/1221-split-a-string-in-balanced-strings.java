class Solution {
    public int balancedStringSplit(String s) {
        if(s.length()%2 != 0)
            return 0;
        
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                count++;
                stack.push(s.charAt(i));
            }
            else{
                // make a choice, either to push to the stack or pop an existing element out            
                if(s.charAt(i) == stack.peek()){
                    stack.push(s.charAt(i));
                }
                else{
                    stack.pop();
                }
            }            
        }
        
        if(!stack.isEmpty())
            return count-1;
        
        return count;        
    }
}