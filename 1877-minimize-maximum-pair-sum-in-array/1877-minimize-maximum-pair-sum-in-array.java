class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int start = 0, end = n-1;
        
        List<Integer> pairs = new ArrayList<>();
        
        while(start < end) {
            pairs.add(nums[start] + nums[end]);
            start++;
            end--;
        }
        
        Collections.sort(pairs);
        
        return pairs.get(pairs.size()-1);        
    }
}