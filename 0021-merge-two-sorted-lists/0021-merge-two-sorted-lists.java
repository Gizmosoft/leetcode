/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        
        
        // ************* BEGIN ITERATIVE METHOD *********//
//       ListNode head = new ListNode();
//       ListNode key = head;
//         while(list2 != null && list1 != null){
//             if(list2.val <= list1.val){
//                 key.next = list2;
//                 list2 = list2.next;
//             }
//             else{
//                 key.next = list1;
//                 list1 = list1.next;
//             }
//             key = key.next;
//         }
        
//         if(list1 != null){
//             while(list1 != null){
//                 key.next = list1;
//                 key = list1;
//                 list1 = list1.next;
//             }
//         }
//         else{
//             while(list2 != null){
//                 key.next = list2;
//                 key = list2;
//                 list2 = list2.next;
//             }
//         }
        
//         return head.next; 
        // ************* END OF ITERATIVE METHOD *********//
        
        
        // ** RECURSIVE SOLUTION** //
        if(list2.val <= list1.val){
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        else{
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        
    }
}