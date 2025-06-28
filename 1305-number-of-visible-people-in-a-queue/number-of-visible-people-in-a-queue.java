class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // Stack Approach
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for(int i=n-1; i>=0; i--) {
            int count = 0;
            while(!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }
            if(!stack.isEmpty()) count++;
            res[i] = count;
            stack.push(heights[i]);
        }
        return res;


        // O(n^2) approach
        // int n = heights.length;
        // if(n == 1) return new int[]{0};
        // int[] res = new int[n];

        // for(int i=0; i<n-1; i++) {
        //     int count = 0;
        //     int max = 0;
        //     for(int j=i+1; j<n; j++) {
        //         if(heights[j] > max) {
        //             max = heights[j];
        //             if(heights[j] > heights[i]) {
        //                 count++;
        //                 break;
        //             }
        //             count++;
        //         }
        //     }
        //     res[i] = count;
        // }
        // return res;
    }
}