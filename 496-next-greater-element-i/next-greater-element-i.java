class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // O(n) approach
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for(int i=0; i<nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                cache.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty())
            cache.put(stack.pop(), -1);

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            ans[i] = cache.get(nums1[i]);
        }
        return ans;

        // O(n^2) 
        // Map<Integer, Integer> cache = new HashMap<>();
        // int n2 = nums2.length;

        // for(int i=0; i<n2; i++) {
        //     cache.put(nums2[i], -1);
        //     for(int j=i+1; j<n2; j++) {
        //         if(nums2[j] > nums2[i]) {
        //             cache.put(nums2[i], nums2[j]);
        //             break;
        //         }
        //     }

        // }

        // int[] ans = new int[nums1.length];
        // for(int i=0; i<nums1.length; i++) {
        //     ans[i] = cache.get(nums1[i]);
        // }
        // return ans;
    }
}