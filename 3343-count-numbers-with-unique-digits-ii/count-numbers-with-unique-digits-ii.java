class Solution {
    public int numberCount(int a, int b) {
        int total = b-a+1;
        for(int i=a; i<=b; i++) {
            String num = String.valueOf(i);
            Set<Character> set = new HashSet<>();
            for(int j=0; j<num.length(); j++) set.add(num.charAt(j));
            if(set.size() < num.length()) total--;
        }
        return total;
    }
}