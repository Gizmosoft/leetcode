class Solution {
    public String longestPalindrome(String s) {
        
        String res = "";
        int len = 0;
        
        for(int i = 0; i < s.length(); i++) {
            // for odd length palindrome
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if((r - l + 1) > len) {
                    res = s.substring(l, r+1);
                    len = r-l+1;
                }
                l--;
                r++;
            }
            
            // for even length palindrome
            l = i; r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if((r-l+1) > len) {
                    res = s.substring(l, r+1);
                    len = r-l+1;
                }
                l--;
                r++;
            }
        }
        
        return res;        
    }
}