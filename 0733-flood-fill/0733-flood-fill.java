class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        
        int target = image[sr][sc];
        
        int[][] result = helper(image, sr, sc, color, visited, target);
        
        return result;
    }
    
    public int[][] helper(int[][] image, int sr, int sc, int color, boolean[][] visited, int target){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != target)
            return image;
        
        if(image[sr][sc] == target){
            image[sr][sc] = color;
        }
        
        visited[sr][sc] = true;
        helper(image, sr-1, sc, color, visited, target); // top
        helper(image, sr+1, sc, color, visited, target); // bootom
        helper(image, sr, sc-1, color, visited, target); // left
        helper(image, sr, sc+1, color, visited, target); // right
        visited[sr][sc] = false;
        
        return image;
    }
}