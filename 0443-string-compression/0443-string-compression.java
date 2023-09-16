class Solution {
    public int compress(char[] chars) {
        Stack<Character> stack = new Stack<>();
        String s = "";
        
        for(int i=0; i<chars.length; i++){
            char ch = chars[i];
            if(stack.isEmpty() || stack.peek() == ch){
                stack.push(ch);
            }
            else{
                int count = stack.size();
                String sCount = String.valueOf(count);
                String sChar = stack.pop().toString();
                if(sCount.equals("1"))
                    s += sChar;
                else
                    s += sChar+sCount;
                stack.clear();
                stack.push(ch);
            }
        }
        
        String count = String.valueOf(stack.size());
        String alpha = stack.peek().toString();
        if(count.equals("1")){
            s += alpha;
        }
        else{
            s += alpha+count;
        }
        int len = s.length();
        for(int i=0; i<len; i++){
            chars[i] = s.charAt(i);
        }
        
        return len;       
    }
}