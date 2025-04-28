class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder("");
        int open = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')' && open > 0) {    // append closing parantheses only when there is something opened already
                sb.append(s.charAt(i));
                open--;
            } else if(s.charAt(i) == '(') {         // append opening parantheses and increment count
                sb.append(s.charAt(i));
                open++;
            } else if(s.charAt(i) != ')') {         // append normal alphabets
                sb.append(s.charAt(i));     
            }
        }

        if(open > 0) {
            for(int i=sb.length()-1; i>=0; i--) {
                if(open == 0) break;
                if(sb.charAt(i) == '(') {
                    sb.deleteCharAt(i);
                    open--;
                }    
            }
        }

        return sb.toString();

        // SLOWER APPROACH - 2 parse
        // int start = 0;
        // int end = s.length()-1;
        // String result = "";

        // char[] arr = s.toCharArray();

        // int openingCount = 0;

        // // Parse from left to right
        // for(int i=0; i<arr.length; i++) {
        //     if(arr[i] == '(')
        //         openingCount++;
        //     else if (arr[i] == ')') {
        //         if (openingCount == 0)
        //             arr[i] = '*';
        //         else
        //             openingCount--;
        //     }
        // }

        // // Parse from right to left
        // for(int i=arr.length-1; i>=0; i--) {
        //     if(openingCount > 0 && arr[i] == '(') {
        //         arr[i] = '*';
        //         openingCount--;
        //     }
        // }

        // for(char c: arr) {
        //     if(c != '*')
        //         result += c;
        // }
        // return result;
    }
}