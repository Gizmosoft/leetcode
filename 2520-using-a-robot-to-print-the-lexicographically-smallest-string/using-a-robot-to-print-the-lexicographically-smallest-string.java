class Solution {
    public String robotWithString(String s) {
        Stack<Character> t = new Stack<>();
        StringBuilder paper = new StringBuilder();
        int n = s.length();

        // Using frequency array
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch : s.toCharArray()) {
            t.push(ch);
            freq[ch - 'a']--;

            // check if we can pop the stack and right the character to paper
            while(!t.isEmpty() && t.peek() <= smallestChar(freq)) {
                paper.append(t.pop());
            }
        }

        while(!t.isEmpty()) {
            paper.append(t.pop());
        }

        return paper.toString();

        // Using Suffix Array
        // char[] minSuf = new char[n];        // the smallest char in array from i'th to last position
        // minSuf[n-1] = s.charAt(n-1);

        // for(int i=n-2; i>=0; i--) {
        //     minSuf[i] = (char) Math.min(s.charAt(i), minSuf[i+1]);
        // }

        // for(int i=0; i<n; i++) {
        //     t.push(s.charAt(i));

        //     // while the top element of the t stack is the min in the rest of the s, pop and write to paper
        //     while(!t.isEmpty() && (i == n-1 || t.peek() <= minSuf[i+1])) {
        //         paper.append(t.pop());
        //     }
        // }
        // return paper.toString();
    }

    private char smallestChar(int[] freq) {
        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}