class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int Rrights = 0;
        int Drights = 0;
        int n = senate.length();
        
        // add all elements from string to queue
        for(int i=0; i<senate.length(); i++) {
            queue.offer(senate.charAt(i));
        }
        
        while(queue.size() != 1) {
            char front = queue.peek();
            if (Rrights + Drights >= n){
                break;
            }
            if(front == 'R'){
                if(Drights > 0) {
                    queue.poll();
                    Drights--;
                }
                else{
                    Rrights++;
                    queue.poll();
                    queue.offer(front);
                }
            }
            else {
                if(Rrights > 0) {
                    queue.poll();
                    Rrights--;
                }
                else {
                    Drights++;
                    queue.poll();
                    queue.offer(front);
                }
            }       
        }
        
        if(queue.peek() == 'R')
            return "Radiant";
        else
            return "Dire";
    }
}