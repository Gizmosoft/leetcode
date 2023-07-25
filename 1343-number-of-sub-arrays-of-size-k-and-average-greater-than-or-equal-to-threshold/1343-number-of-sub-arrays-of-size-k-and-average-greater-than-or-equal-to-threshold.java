class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // MORE EFFICIENT WAY
        
        if(k>arr.length)
            return 0;
        
        int count = 0;
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        
        if(sum >= k*threshold)
            count++;
        
        for(int i=0; i<arr.length-k; i++){
            sum = sum - arr[i] + arr[i+k];
            if(sum >= k*threshold)
                count++;
        }
        
        return count;
        
        
        // BRUTE FORCE
//         int count = 0;
        
//         for(int i=0; i<=arr.length-k; i++){
//             int sum = 0;
//             for(int j=i; j<i+k; j++){
//                 sum += arr[j];
//             }
//             if(sum >= k*threshold)
//                 count++;
//         }
        
//         return count;
        
    }
}