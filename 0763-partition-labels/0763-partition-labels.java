class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        // store max index of where each character is present in the string
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        
        List<Integer> list = new ArrayList<>();
        int maxIndex = 0, prev = -1;     // keep track of max limit of current partition and boundary of previous partition
        
        for(int i=0; i<n; i++) {
            maxIndex = Math.max(maxIndex, map.get(s.charAt(i)));
            
            // when to do a new partition
            if(maxIndex == i) {
                list.add(maxIndex - prev);  // max-prev gives the total length of the partition
                prev = maxIndex;     //update prev to new value that is max
            }
        }
        return list;
    }
}