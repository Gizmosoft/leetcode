class Solution {
    public int strStr(String haystack, String needle) {
        int windowSize = needle.length();
        
        int n = haystack.length();
        
        int i = 0;
        
        while(i+windowSize <= n) {
            String sub = haystack.substring(i, i+windowSize);
            if(sub.equals(needle)){
                return i;
            }
            i++;
        }
        
        return -1;        
    }
}