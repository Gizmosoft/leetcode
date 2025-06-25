class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int left = Math.max(0, j - k);
                int right = Math.min(n - 1, j + k);
                for (int i = left; i <= right; i++) {
                    marked[i] = true;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (marked[i]) res.add(i);
        }
        return res;
    }
}