class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        if(m==0) return;
        int EMPTY = Integer.MAX_VALUE;
        int GATE = 0;
        Queue<int[]> queue = new LinkedList<>();
        // add the coords of the gate to the queue
        for(int i=0; i<m; i++) {
            for(int j=0; j<n;j++) {
                if(rooms[i][j] == GATE) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] currGate = queue.poll();
            int row = currGate[0];
            int col = currGate[1];
            for(int[] dir: directions) {
                int x = row + dir[0], y = col + dir[1];
                if(x >=0 && x < m && y >= 0 && y < n && rooms[x][y] == EMPTY) {
                    rooms[x][y] = rooms[row][col] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}