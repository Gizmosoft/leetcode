class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int pairs = 0;

        for(int i=0; i<n; i++) {
            int right = n-1;
            while(right > i) {
                if(nums.get(i) + nums.get(right) < target){
                    pairs++;
                }
                right--;
            }
        }
        return pairs;
    }
}