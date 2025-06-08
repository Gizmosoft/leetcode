class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        // For Dynamic Programming
        Map<String, List<String>> dp = new HashMap<>();
        return dfs(s, dp, wordSet);
        // For Backtracking
        // List<String> results = new ArrayList<>();
        // backtrack(s, wordSet, new StringBuilder(), results, 0);
        // return results;
    }

    // Dynamic Programming
    private List<String> dfs(String remainingStr, Map<String, List<String>> dp, Set<String> wordSet) {
        if(dp.containsKey(remainingStr)) return dp.get(remainingStr);

        // base case
        if(remainingStr.isEmpty()) return Collections.singletonList("");
        List<String> result = new ArrayList<>();

        for(int i=1; i<=remainingStr.length(); i++) {
            String currWord = remainingStr.substring(0, i);
            if(wordSet.contains(currWord)) {
                for(String nextWord: dfs(remainingStr.substring(i), dp, wordSet)) {
                    result.add(currWord + (nextWord.isEmpty() ? "" : " ") + nextWord);
                }
            }
        }
        dp.put(remainingStr, result);
        return result;
    }

    // BACKTRACKING
    // private void backtrack(String s, Set<String> wordSet, StringBuilder currSentence, List<String> results, int startIndex) {
    //     if(startIndex == s.length()) {
    //         results.add(currSentence.toString().trim());
    //         return;
    //     }

    //     for(int endIndex=startIndex+1; endIndex <= s.length(); endIndex++) {
    //         String word = s.substring(startIndex, endIndex);

    //         if(wordSet.contains(word)) {
    //             int currLen = currSentence.length();
    //             currSentence.append(word).append(" ");
    //             backtrack(s, wordSet, currSentence, results, endIndex);
    //             currSentence.setLength(currLen);
    //         }
    //     }
    // }
}