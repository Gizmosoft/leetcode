class Solution {
    public int countSubstrings(String s) {
        // DYNAMIC PROGRAMMING APPROACHING
        int n = s.length(), res = 0;
        boolean[][] tracker = new boolean[n][n];

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i <= 1 || tracker[i+1][j-1]) {
                        tracker[i][j] = true;
                        res++;
                    }
                }
            }
        }

        return res;


        // TWO POINTER APPROACH
        // int res = 0;

        // for(int i=0; i<s.length(); i++) {
        //     int l = i, r = i;
        //     res += countPalindromes(s, l, r);

        //     l = i;
        //     r = i+1;
        //     res += countPalindromes(s, l, r);
        // }

        // return res;
    }

//     private int countPalindromes(String s, int l, int r) {
//         int res = 0;

//         while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
//             res += 1;
//             l -= 1;
//             r += 1;
//         }
//         return res;
//     }
}