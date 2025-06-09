class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));     // sort matrix based on the 0th index

        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        endTime.offer(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if(start >= endTime.peek()) endTime.poll();
            endTime.offer(end);
        }

        return endTime.size();
    }
}