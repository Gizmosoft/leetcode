class Solution {
    public int[] findBuildings(int[] heights) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for(int i=heights.length-1; i>=0; i--) {
            if(heights[i] > max) {
                max = heights[i];
                pq.add(i);
            }
        }

        int[] ans = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }

        return ans;
    }
}