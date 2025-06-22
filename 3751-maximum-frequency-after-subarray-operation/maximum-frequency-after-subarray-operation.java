class Solution {
    public int maxFrequency(int[] nums, int k) {
        // get unique values from the nums array and store it in a set
        Set<Integer> uniqueValues = new HashSet<>();
        int kCount = 0;
        for(int num : nums) {
            uniqueValues.add(num);
            if(num == k) kCount++;
        }

        int maxGain = 0;

        // try each unique value as a target and compute the gain
        // if num == target gain++, num == k gain--
        for(int target : uniqueValues) {
            if(target == k) continue; // ignore if target is already k, we don't need to convert that

            int gain = 0, currentGain = 0;
            for(int num : nums) {
                if(num == target) currentGain++;
                else if (num == k) currentGain--;

                currentGain = Math.max(0, currentGain);
                gain = Math.max(gain, currentGain);
            }
            maxGain = Math.max(maxGain, gain);
        }

        return kCount + maxGain;
    }

    // private int bruteForceApproach(int[] nums, int k) {
    //     int n = nums.length;
    //     int maxFreq = countOccurrences(nums, k);

    //     // if all values are already equal to k, return n
    //     if (maxFreq == n) return n;

    //     // build subarray
    //     for(int i=0; i<n; i++) {
    //         for(int j=i; j<n; j++) {
    //             Set<Integer> xValues = new HashSet<>();
    //             // compute x values for each element in the subarray and count frequency of k in the whole array after conversion
    //             for(int index=i; index<=j; index++) {
    //                 // nums[index] + x = k --> x = k - nums[index]
    //                 int x = k - nums[index];

    //                 // check if this x is already been computed for
    //                 if(xValues.contains(x)) continue;   // skip if already computed for this x

    //                 xValues.add(x);

    //                 int freq = 0;
    //                 for(int pos=0; pos<n; pos++) {
    //                     // inside subarray
    //                     if(i <= pos && pos <= j) {
    //                         if(nums[pos] + x == k) freq++;
    //                     } 
    //                     // outside subarray
    //                     else {
    //                         if(nums[pos] == k) freq++;
    //                     }
    //                 }
    //                 maxFreq = Math.max(maxFreq, freq);
    //             }
    //         }
    //     }
    //     return maxFreq;
    // }

    // private int countOccurrences(int[] nums, int k) {
    //     int count = 0;
    //     for(int n : nums) {
    //         if(n == k) count++;
    //     }
    //     return count;
    // }
}