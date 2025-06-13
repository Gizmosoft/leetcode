class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[26];
        int maxCurrFreq = 0;
        int longestSubLen = 0;

        for(int right = 0; right < s.length(); right++) {
            int currChar = s.charAt(right) - 'A';
            freq[currChar] += 1;
            maxCurrFreq = Math.max(maxCurrFreq, freq[currChar]);

            boolean isValidSubstring = (right + 1 - left - maxCurrFreq <= k);
            if(!isValidSubstring) {
                int removedChar = s.charAt(left) - 'A';
                freq[removedChar]--;
                left += 1;
            }
            longestSubLen = Math.max(longestSubLen, (right + 1 - left));
        }
        return longestSubLen;
    }
}