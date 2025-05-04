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
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode left = head;
        ListNode right = left.next;

        while(right != null) {
            if(left.val == right.val) {
                left.next = right.next;
                right = left.next;
                if(head == null || head.next == null)
                    head = left;
            }
            else {
                left = left.next;
                right = right.next;
            }
        }
        return head;
    }
}