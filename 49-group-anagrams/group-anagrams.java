class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<String> sortKey = new ArrayList<>();

        for(String s : strs) {
            String elem = sortString(s);
            int index = sortKey.indexOf(elem);
            if(index == -1) {
                sortKey.add(elem);
                List<String> l = new ArrayList<>();
                l.add(s);
                ans.add(l);
            } else {
                List<String> l = ans.get(index);
                l.add(s);
            }
        }
        return ans;
    }

    private String sortString(String s) {
        char[] sChar = s.toCharArray();     // "eat" ==> ['e', 'a', 't']
        Arrays.sort(sChar);
        return new String(sChar);
    }
}