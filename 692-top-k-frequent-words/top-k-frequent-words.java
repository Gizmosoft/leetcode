class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();

        for(String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int cmp = wordCount.get(b) - wordCount.get(a);
            if(cmp !=0) return cmp;
            return a.compareTo(b);
        });

        wordCount.keySet().forEach(word -> {
            pq.offer(word);
        });

        List<String> ans = new ArrayList<>();
        for(int i=0; i<k; i++) {
            ans.add(pq.poll());
        }
        return ans;
    }
}