import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<>();
        
        int n = deck.length;
        Arrays.sort(deck);  // sort deck
        
        int[] ans = new int[n];
        
        // store indices
        for(int i=0; i<n; i++){
            q.offer(i);
        }
        
        for(int i=0; i<n; i++){
            ans[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        
        return ans;
    }
}