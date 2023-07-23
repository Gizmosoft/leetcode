class Solution {
    public int countGoodSubstrings(String s) {
        int window = 3;
        int count = 0;
        
        for(int i=0; i<=s.length()-window; i++){
            if(isGood(s.substring(i, i+window), window))
                count++;
        }
        
        return count;
    }
    
    public boolean isGood(String s, int w){
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<w; i++){
            if(map.getOrDefault(s.charAt(i), 0) == 0){
                map.put(s.charAt(i), 1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}