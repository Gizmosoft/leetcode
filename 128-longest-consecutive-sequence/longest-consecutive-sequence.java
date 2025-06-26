class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums[i], false);
        }

        int maxCount = 0;
        for(int i=0; i<n; i++) {
            if(map.get(nums[i])) continue;

            int count = 1;
            int temp = nums[i];
            
            // parsing left
            while(map.containsKey(temp-1)) {
                temp = temp - 1;
                map.put(temp, true);
                count++;
            }

            temp = nums[i];
            // parsing right
            while(map.containsKey(temp+1)) {
                temp = temp + 1;
                map.put(temp, true);
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}