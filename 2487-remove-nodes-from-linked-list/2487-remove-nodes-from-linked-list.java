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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        while(head.next != null){
            head = head.next;
            temp.next = prev;
            prev = temp;
            temp = head;
        }
        head.next = prev;
        return head;
    }
    public ListNode removeNodes(ListNode head) {
        if(head.next == null)
            return head;
        
        // reverse the list to make ops easier
        head = reverse(head);
        
        ListNode key = head.next;
        
        ListNode max = head;
        
        while(key != null){
            if(key.val < max.val){
                // remove that node
                ListNode temp = key;
                key = key.next;
                max.next = key;
                temp.next = null;
            }
            else{
                max = key;
                key = key.next;                
            }
        }
        
        // reverse the list again to return it in the desired format
        head = reverse(head);
        return head;
    }
}