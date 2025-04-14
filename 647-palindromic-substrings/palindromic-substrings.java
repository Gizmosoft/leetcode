class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for(int i=0; i<s.length(); i++) {
            int l = i, r = i;
            res += countPalindromes(s, l, r);

            l = i;
            r = i+1;
            res += countPalindromes(s, l, r);
        }

        return res;
    }

    private int countPalindromes(String s, int l, int r) {
        int res = 0;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res += 1;
            l -= 1;
            r += 1;
        }
        return res;
    }
}