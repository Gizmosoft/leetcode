class Solution {
    public String reorganizeString(String s) {
        return greedySol(s);        
    }

    public String greedySol(String s) {
        int[] charCounts = new int[26];
        for(char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Compute the ost frequent character in the string along with its count
        int maxCount = 0, maxCharIndex = 0;
        for(int i=0; i<charCounts.length; i++) {
            if(charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                maxCharIndex = i;
            }
        }

        if(maxCount > (s.length() + 1)/2) return "";    // FAILURE Condition

        char[] ans = new char[s.length()];
        int index = 0;

        // Place the most frequent character alternatively first
        while(charCounts[maxCharIndex] != 0) {
            ans[index] = (char) (maxCharIndex + 'a');
            index += 2;
            charCounts[maxCharIndex]--;
        }

        // Placing the rest of the characters in other positions
        for(int i=0; i<charCounts.length; i++) {
            while(charCounts[i] > 0) {
                if(index >= s.length()) index=1;    // prevent going out of bounds

                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }
}