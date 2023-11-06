class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int row = 0;
        while(matrix[row][n] < target){
          row++;
          if(row > m)
             return false;
        }
        int arr[] = matrix[row];
        int first = 0, last = n, mid = (first + last)/2;
        while(first <= last){
          if(arr[mid] < target)
              first = mid + 1;
          else if(arr[mid] == target)
              return true;
          else
              last = mid - 1;
          mid = (first + last)/2;
        }
        return false;
    }
}