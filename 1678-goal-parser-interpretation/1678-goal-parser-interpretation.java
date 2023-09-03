import java.util.*;

class Solution {
    public String interpret(String command) {
        Stack<Character> stack = new Stack<>();
        
        String result = "";
        
        for(int i=0; i<command.length(); i++){
            // case 1 = if character is G
            if(command.charAt(i) == 'G')
                result += "G";
            else if(command.charAt(i) == ')'){
                stack.pop();
                if(stack.isEmpty())
                    result += "o";
                else{
                    result += "al";
                    stack.clear();
                }
            }
            else{
                stack.push(command.charAt(i));
            }
        }
        
        return result;        
    }
}