/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getLargestIndex(int[] arr, int start, int end){
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i=start; i<=end; i++){
            if(arr[i] >= max){
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int start, int end){
        if(start > end)
            return null;
        
        int index = getLargestIndex(nums, start, end);
        TreeNode head = new TreeNode(nums[index]);
        
        head.left = helper(nums, start, index-1);
        head.right = helper(nums, index+1, end);
        
        return head;
    }
}