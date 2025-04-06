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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;

        ListNode temp = head;
        while(head.next != null) {
            ListNode left = head;
            ListNode right = head.next;
            int gcd = gcd(left.val, right.val);
            ListNode node = new ListNode(gcd);
            left.next = node;
            node.next = right;
            head = right;
        }
        
        head = temp;
        return head;
    }

    public int gcd(int a, int b) {
        while(b!=0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}