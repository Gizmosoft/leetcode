class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (String s : strs)
            while (!s.startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);

        return prefix;
    }
//         String res = "";
        
//         // get the length of the smallest word in the array
//         int lowLen = getLenOfSmallest(strs);
//         int i=0;
//         while(i < lowLen) {
//             Character c = Character.MIN_VALUE;
//             for(String s : strs) {
//                 if(c == Character.MIN_VALUE || c == s.charAt(i)) {
//                     c = s.charAt(i);
//                 } else {
//                     return res;
//                 }
//             }
//             res += c.toString();
//             i++;
//         }
        
//         return res;
//     }
    
//     public static int getLenOfSmallest(String[] strs) {
//         int len = Integer.MAX_VALUE;
//         for(String s : strs) {
//             len = Math.min(len, s.length());
//             // System.out.println(len);
//         }
//         return len;
//     }
}