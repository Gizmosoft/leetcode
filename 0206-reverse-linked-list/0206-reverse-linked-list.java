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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode far = head.next;
        
        // *** iterative solution
        // while(far!=null){
        //     head.next = prev;
        //     prev = head;
        //     head = far;
        //     far = head.next;
        // }
        // head.next = prev;
        // *** iterative solution
        
        // *** recursive solution
        head = getReverse(head, prev, far);
        // *** recursive solution
        
        return head;
        
    }
    
    public ListNode getReverse(ListNode head, ListNode prev, ListNode far){
        if(far == null){
            head.next = prev;
            return head;
        }
        
        head.next = prev;
        // prev = head;
        // head = far;
        // far = head.next;
        return getReverse(far, head, far.next);
    }
}