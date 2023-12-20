class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int[] g : grid) {
            count += binarySearch(g, n, m);
        }
        
        return count;       
    }
    
    public static int binarySearch(int[] array, int n, int m) {
        int l = 0;
        int r = m-1;
        
        int count = 0;
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            
            if(array[mid] < 0){
                count += r + 1 - mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return count;        
    }
}