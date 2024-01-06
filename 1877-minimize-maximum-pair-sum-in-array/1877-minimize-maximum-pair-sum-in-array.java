class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int start = 0, end = n-1;
        
        // List<Integer> pairs = new ArrayList<>();
        int sum = Integer.MIN_VALUE;
        
        while(start < end) {
            // pairs.add(nums[start] + nums[end]);
            sum = Math.max(sum, nums[start] + nums[end]);
            start++;
            end--;
        }
        
        // Collections.sort(pairs);
        
        // return pairs.get(pairs.size()-1); 
        return sum;
    }
}