class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // USING COUNT CATEGORIZATION AND HASHMAP - O(nk)
        if(strs.length == 0) return new ArrayList<>();
        int[] count = new int[26];
        Map<String, List<String>> ans = new HashMap<>();
        for(String s : strs) {
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

        // USING HASHMAP - O(n*klogk)
        // if(strs.length == 0) return new ArrayList<>();

        // Map<String, List<String>> ans = new HashMap<>();
        // for(String s : strs) {
        //     char[] ch = s.toCharArray();
        //     Arrays.sort(ch);
        //     String key = String.valueOf(ch);
        //     if(!ans.containsKey(key)) ans.put(key, new ArrayList<>());
        //     ans.get(key).add(s);
        // }
        // return new ArrayList(ans.values());

        // BRUTE FORCE
        // List<List<String>> ans = new ArrayList<>();
        // List<String> sortKey = new ArrayList<>();

        // for(String s : strs) {
        //     String elem = sortString(s);
        //     int index = sortKey.indexOf(elem);
        //     if(index == -1) {
        //         sortKey.add(elem);
        //         List<String> l = new ArrayList<>();
        //         l.add(s);
        //         ans.add(l);
        //     } else {
        //         List<String> l = ans.get(index);
        //         l.add(s);
        //     }
        // }
        // return ans;
    }

    // private String sortString(String s) {
    //     char[] sChar = s.toCharArray();     // "eat" ==> ['e', 'a', 't']
    //     Arrays.sort(sChar);
    //     return new String(sChar);
    // }
}