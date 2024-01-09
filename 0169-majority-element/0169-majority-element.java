class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // populate map with frequencies
        for(int i=0; i<nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        
        // int key = 0, value = Integer.MIN_VALUE;
        int[] keyValues = {0, Integer.MIN_VALUE};
        
        map.forEach((k, v) -> {
            if(v > keyValues[1]) {
                keyValues[0] = k;
                keyValues[1] = v;
            }
        });
        
        return keyValues[0];     
    }
}