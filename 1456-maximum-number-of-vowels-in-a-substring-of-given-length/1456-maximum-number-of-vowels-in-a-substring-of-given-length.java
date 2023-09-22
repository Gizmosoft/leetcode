class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int left = 0;
        int count = 0;
        
        for(left = 0; left < k; left++){
            if(s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' || s.charAt(left) == 'o' || s.charAt(left) == 'u') {
                count += 1;
            }
        }
        
        maxCount = count;
        
        while(left < s.length()){
            if(isVowel(s.charAt(left))){
                count++;
            }

            if(isVowel(s.charAt(left-k))){
                count--;
            }
            maxCount = Math.max(maxCount, count);
            left++;
        }
        
        return maxCount;
    }
    
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
}