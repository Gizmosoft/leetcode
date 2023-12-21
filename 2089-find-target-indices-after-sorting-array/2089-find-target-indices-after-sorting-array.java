class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int smaller = 0;
        int larger = 0;
        
        int n = nums.length;
        
        for(int i : nums) {
            if(i < target)
                smaller++;
            if(i > target)
                larger++;
        }
        for(int i = smaller; i<=n-larger-1; i++){
            list.add(i);
        }
        return list;
    }
}