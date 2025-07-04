class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;  
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // All chars found
        if(index == word.length()) return true;

        // Out of bounds failure
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        // Word not present failure
        if(board[row][col] != word.charAt(index)) return false;

        char ch = board[row][col];
        board[row][col] = '#';      // Mark as visited

        boolean charFound = backtrack(board, word, row-1, col, index+1) || backtrack(board, word, row, col+1, index+1) || backtrack(board, word, row+1, col, index+1) || backtrack(board, word, row, col-1, index+1);
        board[row][col] = ch;

        return charFound;
    }
}