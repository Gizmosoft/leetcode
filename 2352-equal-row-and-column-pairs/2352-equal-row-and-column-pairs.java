class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int flag = 0, result = 0;
        
        // create rows
        int[] row = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                row[j] = grid[i][j];
            }
            flag = checkFlag(grid, row);
            result += flag;
        }
        
        return result;
        
    }
    
    public int checkFlag(int[][] grid, int[] row) {
        int count = 0, flag = 0;
        int n = grid.length;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[j][i] == row[j])
                    count++;
                else
                    break;
            }
            
            if(count == n) {
                flag++;
            }
            count = 0;
        }
        
        return flag;
    }
}