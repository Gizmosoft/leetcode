class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char number = board[i][j];
                // All checks happen if number is not a dot '.'
                if(number != '.')
                    // check if the number being added is already present or not
                    // if its present the add() method returns false and ! of it will make it true
                    // in that case return false as output
                    if(!set.add(number + "row" + i) ||
                       !set.add(number + "col" + j) ||
                       !set.add(number + "box" + i/3 + j/3)
                      )
                        return false;
            }
        }
        return true;
    }
}