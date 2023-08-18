class RecentCounter {
    
    public Queue<Integer> req;

    public RecentCounter() {
        req = new LinkedList<>();        
    }
    
    public int ping(int t) {
        req.offer(t);
        
        while(req.peek() < t-3000){   // if the front most element in queue is older than 3000ms then remove that
            req.poll();
        }
        
        return req.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */