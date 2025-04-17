class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] counter = new int[26];
        for(int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int count : counter) {
            if(count != 0) {
                return false;
            }
        }
        return true;

        // if(s.length() != t.length()) return false;
        // int[] sCount = new int[26];
        // int[] tCount = new int[26];

        // for(int i=0; i<s.length(); i++) {
        //     int sIndex = s.charAt(i) - 'a';
        //     sCount[sIndex]++;
        //     int tIndex = t.charAt(i) - 'a';
        //     tCount[tIndex]++;
        // }

        // String sString = Arrays.toString(sCount);
        // String tString = Arrays.toString(tCount);

        // if(sString.equals(tString)) return true;
        // return false;
    }
}