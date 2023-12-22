class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int result = 0, i = 0, j = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        // intitialize map
        map.put('T', 0);
        map.put('F', 0);
        
        while(j < answerKey.length()) {
            // update the value of the current window end key in map
            map.put(answerKey.charAt(j), map.get(answerKey.charAt(j))+1);
            
            // while the minimum value of the values of T and F in the map exceeds k, reduce the size of the window by incrementing i and decrementing the corresponding value in the map
            while(Math.min(map.get('T'), map.get('F')) > k) {
                map.put(answerKey.charAt(i), map.get(answerKey.charAt(i))-1);
                i++;
            }
            
            result = Math.max(result, j-i+1);   // store the max of the existing result and window size
            j++;    // move j to extend window            
        }
        return result;
    }
}