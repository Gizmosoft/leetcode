import java.util.*;

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        if(nums.length < 3){
            return 0;
        }
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int k = nums.length-1;
                while(k>j){
                    if(nums[k]-nums[j] == diff && nums[j]-nums[i] == diff){
                        set.add(Integer.toString(i) + "," + Integer.toString(j) + "," + Integer.toString(k));
                    }
                    k--;
                }
            }
        }
        
        return set.size();
    }
}