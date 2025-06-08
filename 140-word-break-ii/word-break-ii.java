class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> results = new ArrayList<>();
        backtrack(s, wordSet, new StringBuilder(), results, 0);
        return results;
    }

    private void backtrack(String s, Set<String> wordSet, StringBuilder currSentence, List<String> results, int startIndex) {
        if(startIndex == s.length()) {
            results.add(currSentence.toString().trim());
            return;
        }

        for(int endIndex=startIndex+1; endIndex <= s.length(); endIndex++) {
            String word = s.substring(startIndex, endIndex);

            if(wordSet.contains(word)) {
                int currLen = currSentence.length();
                currSentence.append(word).append(" ");
                backtrack(s, wordSet, currSentence, results, endIndex);
                currSentence.setLength(currLen);
            }
        }
    }
}