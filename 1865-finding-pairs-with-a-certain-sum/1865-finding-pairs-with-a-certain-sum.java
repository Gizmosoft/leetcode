class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map1;
    private Map<Integer, Integer> map2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
        // store frequencies of each number in each array
        for(int i=0; i<nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i],0) + 1);
        }
        for(int j=0; j<nums2.length; j++) {
            map2.put(nums2[j], map2.getOrDefault(nums2[j],0) + 1);
        }
    }
    
    public void add(int index, int val) {
        // update new value with it's frequency in the map
        map2.put(nums2[index], map2.get(nums2[index])-1);
        map2.put(nums2[index]+val, map2.getOrDefault(nums2[index]+val, 0) + 1);
        nums2[index] += val;
    }
    
    public int count(int tot) {
        int count = 0;
        
        for(Integer n1 : map1.keySet()) {
            if(map2.containsKey(tot-n1)){
                count += map2.get(tot-n1)*map1.get(n1);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */