class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // boolean[][] visited = new boolean[image.length][image[0].length];
        
        int target = image[sr][sc];
        
        if(image[sr][sc] == color)
            return image;
        
        int[][] result = helper(image, sr, sc, color, target);
        
        return result;
    }
    
    public int[][] helper(int[][] image, int sr, int sc, int color, int target){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != target)
            return image;
        
        image[sr][sc] = color;
        
        helper(image, sr-1, sc, color, target); // top
        helper(image, sr+1, sc, color, target); // bootom
        helper(image, sr, sc-1, color, target); // left
        helper(image, sr, sc+1, color, target); // right
        
        return image;
    }
}