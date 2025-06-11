class Solution {
    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) 
                    queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0) return 0;

        int minutes = -1;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] curr = queue.poll();
                for(int[] dir : directions) {
                    int x = curr[0] + dir[0], y = curr[1] + dir[1];
                    if(x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                    }
                }
                size--;
            }
            minutes++;
        }

        return (fresh == 0) ? minutes : -1;
    }   
}