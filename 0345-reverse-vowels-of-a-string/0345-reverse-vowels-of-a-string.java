class Solution {
    public String reverseVowels(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        StringBuilder str = new StringBuilder(s);
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
                stack.push(s.charAt(i));
                str.setCharAt(i, '*');
            }
        }
        
        for(int i=0; i<s.length(); i++){
            if(str.charAt(i) == '*'){
                str.setCharAt(i, stack.pop());
            }
        }
        
        return str.toString();        
    }
}