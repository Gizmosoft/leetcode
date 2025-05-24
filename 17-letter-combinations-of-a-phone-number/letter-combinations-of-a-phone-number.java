class Solution {
    private Map<Character, String> letters = Map.of(
        '2',
        "abc",
        '3',
        "def",
        '4',
        "ghi",
        '5',
        "jkl",
        '6',
        "mno",
        '7',
        "pqrs",
        '8',
        "tuv",
        '9',
        "wxyz"
    );

    private List<String> combo = new ArrayList<>();
    private String number;

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return combo;

        number = digits;
        backtrack(0, new StringBuilder());
        return combo;
    }   

    public void backtrack(int i, StringBuilder path) {
        if(path.length() == number.length()) {
            combo.add(path.toString());
            return;
        }

        String possibleLetters = letters.get(number.charAt(i));
        for(char letter : possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(i+1, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}