class Solution {
    public String decodeString(String s) {
        Stack<Character> stringStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        String temp = "", result = "";
        
        for(int i=0; i<s.length(); i++) {
            
            // case 1: if character is a digit
            if(Character.isDigit(s.charAt(i))) {
                int count = 0;
                // get the integer count
                while(Character.isDigit(s.charAt(i))) {
                    count = count*10 + s.charAt(i) - '0';
                    i++;
                }
                // readjusting i so that [ char doesn't get ignored
                i--;
                // push this count to the numberStack
                numberStack.push(count);                
            }
            
            // case 2: if character is [
            else if(s.charAt(i) == ']') {
                // keep popping characters until [ is not found
                int count = 0;
                temp = "";
                
                if(!numberStack.isEmpty()) {
                    count = numberStack.pop();
                }
                
                while(!stringStack.isEmpty() && stringStack.peek()!='[') {
                    temp = stringStack.pop() + temp;
                }
                
                if(!stringStack.isEmpty() && stringStack.peek()=='[') {
                    stringStack.pop();
                }
                
                // for count number of times, append result with temp
                for(int j=0; j<count; j++) {
                    result += temp;
                }
                
                // push the result characters to the stringStack
                for(int j=0; j<result.length(); j++) {
                    stringStack.push(result.charAt(j));
                }
                
                // reset result
                result = "";
            }
            
            // case 3: is character is [
            else if(s.charAt(i) == '[') {
                // check if the previous element is a digit, if yes then simply push this character to the stack
                if(Character.isDigit(s.charAt(i-1))) {
                    stringStack.push(s.charAt(i));
                } 
                // else push the character to the character string and push a 1 to the number stack representing the count of this string to be executed
                else {
                    stringStack.push(s.charAt(i));
                    numberStack.push(1);
                }
            }
            
            // else case: character is an alphabet
            else {
                // just push the character to the stringStack
                stringStack.push(s.charAt(i));
            }
        }
        
        // pop all elements from the stringStack and make a string and return it
        while(!stringStack.isEmpty()) {
            result = stringStack.pop() + result;
        }
        
        return result;        
    }
}