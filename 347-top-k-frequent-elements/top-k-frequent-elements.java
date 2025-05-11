class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // HEAPS
        if(k == nums.length) return nums;

        // map : number -> frequency
        Map<Integer, Integer> count = new HashMap();
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // heap
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        for(int n: count.keySet()) {
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }

        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}