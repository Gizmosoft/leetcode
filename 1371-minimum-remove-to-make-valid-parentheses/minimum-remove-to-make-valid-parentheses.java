class Solution {
    public String minRemoveToMakeValid(String s) {
        int start = 0;
        int end = s.length()-1;
        String result = "";

        char[] arr = s.toCharArray();

        int openingCount = 0;

        // Parse from left to right
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == '(')
                openingCount++;
            else if (arr[i] == ')') {
                if (openingCount == 0)
                    arr[i] = '*';
                else
                    openingCount--;
            }
        }

        // Parse from right to left
        for(int i=arr.length-1; i>=0; i--) {
            if(openingCount > 0 && arr[i] == '(') {
                arr[i] = '*';
                openingCount--;
            }
        }

        for(char c: arr) {
            if(c != '*')
                result += c;
        }
        return result;
    }
}