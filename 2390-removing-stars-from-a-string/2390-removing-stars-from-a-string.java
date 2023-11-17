class Solution {
    public String removeStars(String s) {
        char[] result = s.toCharArray();
        int flag = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(result[i] != '*') {
                result[flag] = result[i];
                flag++;
            } else if(flag > 0 && result[flag-1] != '*') {
                flag--;
            }
        }
        
        return new String(result, 0, flag);
//         Stack<Character> stack = new Stack<>();
//         String result = "";
        
//         for(int i=0; i<s.length(); i++) {
//             char ch = s.charAt(i);
//             if(ch == '*') {
//                 stack.pop();
//             } else {
//                 stack.push(ch);
//             }
//         }
        
//         for(Character c : stack) {
//             result += c;
//         }
        
//         return result;
    }
}