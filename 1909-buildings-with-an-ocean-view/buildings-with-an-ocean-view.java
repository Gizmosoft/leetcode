class Solution {
    public int[] findBuildings(int[] heights) {
        // O(n) time and O(n) space
        int n = heights.length;
        List<Integer> list = new ArrayList<>();     // stores index of allowed buildings

        for(int i=0; i<n; i++) {
            // if current building taller than the last added building to list, remove all previous elements in list
            while(!list.isEmpty() && heights[list.get(list.size()-1)] <= heights[i]) {
                list.remove(list.size() - 1);
            }
            list.add(i);
        }

        // transfer list indexes to array
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
        
        // O(nlogn) Time & O(n) space
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int max = 0;
        // for(int i=heights.length-1; i>=0; i--) {
        //     if(heights[i] > max) {
        //         max = heights[i];
        //         pq.add(i);
        //     }
        // }

        // int[] ans = new int[pq.size()];
        // int i = 0;
        // while(!pq.isEmpty()) {
        //     ans[i++] = pq.poll();
        // }

        // return ans;
    }
}