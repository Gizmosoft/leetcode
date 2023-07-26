class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int res = 0;
        
        if(grid == null) return 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] != 0){
                    res += dfs(grid, i, j);
                }
            }
        }
        return res;        
    }
    
    public int dfs(int[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
            return 1;
        
        if(grid[row][col] == 0)
            return 1;
        
        if(grid[row][col] == -1)
            return 0;
        
        int cnt = 0;
        
        grid[row][col] = -1;
        
        cnt += dfs(grid, row-1, col); // top
        cnt += dfs(grid, row+1, col); // down
        cnt += dfs(grid, row, col-1); // left
        cnt += dfs(grid, row, col+1); // right
        
        return cnt;
    }
}