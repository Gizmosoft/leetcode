class Solution {
    public int compress(char[] chars) {
//         FASTER APPROACH
        String s = String.valueOf(chars[0]);
        int count = 1;
        
        for(int i=1; i<chars.length; i++){
            char curr = chars[i];
            char prev = chars[i-1];
            
            if(curr == prev){
                count++;
            }
            else{
                if(count > 1){
                    s += String.valueOf(count);
                    count = 1;
                }
                s += curr;
            }
        }
        
        if(count > 1){
            s += String.valueOf(count);
            count = 1;
        }
        
        int len = s.length();
        for(int i=0; i<len; i++){
            chars[i] = s.charAt(i);
        }
        
        return len;
        
//         SLOWER APPROACH
//         Stack<Character> stack = new Stack<>();
//         String s = "";
        
//         for(int i=0; i<chars.length; i++){
//             char ch = chars[i];
//             if(stack.isEmpty() || stack.peek() == ch){
//                 stack.push(ch);
//             }
//             else{
//                 int count = stack.size();
//                 String sCount = String.valueOf(count);
//                 String sChar = stack.pop().toString();
//                 if(sCount.equals("1"))
//                     s += sChar;
//                 else
//                     s += sChar+sCount;
//                 stack.clear();
//                 stack.push(ch);
//             }
//         }
        
//         String count = String.valueOf(stack.size());
//         String alpha = stack.peek().toString();
//         if(count.equals("1")){
//             s += alpha;
//         }
//         else{
//             s += alpha+count;
//         }
//         int len = s.length();
//         for(int i=0; i<len; i++){
//             chars[i] = s.charAt(i);
//         }
        
//         return len;       
    }
}