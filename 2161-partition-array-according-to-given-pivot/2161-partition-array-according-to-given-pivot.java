class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        
        // get count of pivot
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == pivot)
                count++;
            else if(nums[i] < pivot)
                smaller.add(nums[i]);
            else
                greater.add(nums[i]);
        }
        
        int[] res = new int[nums.length];
        
        for(int i=0; i<smaller.size(); i++){
            res[i] = smaller.get(i);
        }
        
        int x = smaller.size();
        for(int i=0; i<count; i++){
            res[x+i] = pivot;
        }
        
        x += count;
        
        for(int i=0; i<greater.size(); i++){
            res[x+i] = greater.get(i);
        }
        
        return res;
        
    }
}