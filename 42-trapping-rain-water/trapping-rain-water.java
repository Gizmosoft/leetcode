class Solution {
    public int trap(int[] height) {
        // BETTER APPROACH
        int n = height.length;
        int leftMax = 0, rightMax = 0, total = 0, left = 0, right = n-1;

        while(left < right) {
            if(height[left] <= height[right]) {
                if(leftMax > height[left]) {
                    total += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left += 1;
            } else {
                if(rightMax > height[right]) {
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right -= 1;
            }
        }

        return total;

        // TC: O(N + N + N), SC: O(N + N)
        // int n = height.length;
        // int[] prefixMax = new int[n];
        // int[] suffixMax = new int[n];

        // // prefix 
        // prefixMax[0] = height[0];
        // for(int i=1; i<n; i++) {
        //     prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        // }

        // // suffix
        // suffixMax[n-1] = height[n-1];
        // for(int i=n-2; i>=0; i--) {
        //     suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        // }

        // int total = 0;
        // for(int i=0; i<n; i++) {
        //     total += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        // }

        // return total;
    }
}