class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int k = j+1;
                int l = nums.length-1;
                
                long newTarget = ((long)target-((long)nums[i] + (long)nums[j]));

                while(k<l){
                    // System.out.println("i: " + i + " j: " + j + " k: " + k + " l: " + l);
                    long sum = nums[k] + nums[l];
                    if(sum<newTarget){
                        k++;
                    }
                    else if(sum>newTarget){
                        l--;
                    }
                    else{
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;                    
                    }
                }
            }   
        }
        result.addAll(set);
        
        return result;
        
    }
}