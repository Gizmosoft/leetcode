class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<String>();
        
        Map<String, String> map = new HashMap<>();
        
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        List<String> res = new ArrayList<>();
        
        int i = 0, n = digits.length();
        
        while(i < n) {
            res = getResultantString(res, map.get(String.valueOf(digits.charAt(i))));
            i++;
        }
        
        return res;
        
    }
    
    public static List<String> getResultantString(List<String> existingList, String currentDigit) {
        List<String> resultant = new ArrayList<>();
        if(existingList.size() == 0) {
            for(char c : currentDigit.toCharArray()) {
                resultant.add(String.valueOf(c));
            }
            return resultant;
        }
        
        for(String s : existingList) {
            for(char c : currentDigit.toCharArray()) {
                resultant.add(s + String.valueOf(c));
            }
        }
        
        return resultant;
        
    }
}