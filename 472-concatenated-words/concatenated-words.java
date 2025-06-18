class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> answer = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();

        for(String word: words) {
            wordSet.remove(word);   // avoid self referencing
            if(canForm(word, wordSet, memo)) {
                answer.add(word);
            }
            wordSet.add(word);      // add back after operation
        }
        return answer;        
    }

    private boolean canForm(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if(memo.containsKey(word)) return memo.get(word);

        for(int i=1; i<word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if(wordSet.contains(prefix)) {
                // check if suffix is also present in the list or we can form that using recursion
                if(wordSet.contains(suffix) || canForm(suffix, wordSet, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }
        memo.put(word, false);
        return false;
    }
}