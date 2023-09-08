class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^a-zA-Z0-9]+", " ");
        s = s.replaceAll("\\s", "");
        s = s.trim();
        s = s.toLowerCase();
        
        int n = s.length();
        
        int limit;
        
        if(n%2 == 0)
            limit = n/2;
        else
            limit = n/2+1;
        
        for(int i=0; i<limit; i++){
            if(s.charAt(i) != s.charAt(n-1-i))
                return false;
        }
        
        return true;
        
    }
}