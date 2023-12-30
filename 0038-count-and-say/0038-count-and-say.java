class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        String str = countAndSay(n-1);
        
        StringBuilder result = new StringBuilder();
        
        int count = 1;
        char currentChar = str.charAt(0);
        
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count).append(currentChar);
                // reset count
                count = 1;
                currentChar = str.charAt(i);
            }
        }
        result.append(count).append(currentChar);
        
        return result.toString();       
    }
}