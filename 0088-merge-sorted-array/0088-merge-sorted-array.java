class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        
        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                // move i'th value of nums1 to i+j+1'th position
                nums1[i+j+1] = nums1[i];
                // decrement i
                i--;
            }
            else {
                // move j'th element of nums2 to i+j+1'th position in nums1
                nums1[i+j+1] = nums2[j];
                // decrement j
                j--;
            }
        }
        // if there are more elements in nums2, move them to j'th position on nums1
        while(j>=0) {
            nums1[j] = nums2[j];
            j--;
        }
    }
   
//     O(nlog(n)) solution
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int j = 0;
//         for(int i=m; i<m+n; i++) {
//             nums1[i] = nums2[j];
//             j++;
//         }
        
//         Arrays.sort(nums1);
        
//     }
}