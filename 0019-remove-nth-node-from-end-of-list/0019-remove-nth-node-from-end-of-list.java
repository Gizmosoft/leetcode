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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        
        if(n<=0)
            return head;
        
        // if(head.next == null && n == 1) // base case !
        //     return null;
        
        ListNode counter = head;
        int count = 1;
        
        // while count the number of total nodes in the list
        while(counter.next != null){
            count++;
            counter = counter.next;
        }
        
        if(count == n){
            head = head.next;
            return head;
        }
        
        // use slow and fast pointers to go the target node
        int rem = 1;
        int target = count - n + 1;
        
        ListNode fast = head;
        ListNode slow = head;
        while(rem != target){
            rem++;
            slow = fast;
            fast = fast.next;
        }
        
        ListNode temp = fast;
        fast = fast.next;
        temp.next = null;
        slow.next = fast;
        
        return head;       
    }
}