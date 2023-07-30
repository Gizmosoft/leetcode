import java.util.*;

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // Memoized approach
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        for(int i=0; i<set.size(); i++){
            if(set.contains(nums[i]-diff) && set.contains(nums[i]+diff))
                count++;
        }
        
        return count;
        
        // Slower Approach
//         if(nums.length < 3){
//             return 0;
//         }
//         Set<String> set = new HashSet<>();
        
//         for(int i=0; i<nums.length-1; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 int k = nums.length-1;
//                 while(k>j){
//                     if(nums[k]-nums[j] == diff && nums[j]-nums[i] == diff){
//                         set.add(Integer.toString(i) + "," + Integer.toString(j) + "," + Integer.toString(k));
//                     }
//                     k--;
//                 }
//             }
//         }
        
//         return set.size();
    }
}