class Solution {
    public String makeSmallestPalindrome(String s) {
        int start = 0, end = s.length()-1;
        
        StringBuilder sb = new StringBuilder(s);
        
        while(start <= end) {
            char st = s.charAt(start);
            char en = s.charAt(end);
            
            if(st != en) {
                int char1 = Character.getNumericValue(st);
                int char2 = Character.getNumericValue(en);
                
                if(char2 > char1) {
                    sb.setCharAt(end, st);
                }
                else {
                    sb.setCharAt(start, en);
                }
            }
            start++;
            end--;
        }
        return sb.toString();
    }
}