class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> dist(b) - dist(a)); 
        
        for(int[] point: points) {
            maxPQ.offer(point);
            if (maxPQ.size() > k) maxPQ.poll();
        }

        int[][] answer = new int[k][2];
        for(int i=0; i<k; i++) {
            answer[i] = maxPQ.poll();
        }
        return answer;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}