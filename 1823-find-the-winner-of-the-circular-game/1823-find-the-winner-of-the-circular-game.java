class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        
        return solve(arr, n, k, (k-1)%n);
        
    }
    
    public int solve(int[] arr, int n, int k, int count){
        if(n == 1)
            return arr[0];
        
        for(int i=count+1; i<n; i++){
            arr[i-1] = arr[i];
        }
        n--;
        
        return solve(arr, n, k, (count+(k-1))%n);
    }
}