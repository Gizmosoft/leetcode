/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Floyd's Hare and Tortoise Algorithm TC: O(n), SC: O(1)
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;

        fast = head;    // reset fast 

        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

        // TC: O(n) SC: O(n)
        // Set<ListNode> seenNodes = new HashSet<>();

        // ListNode node = head;
        // while(node != null) {
        //     if(seenNodes.contains(node)) {
        //         return node;
        //     } else {
        //         seenNodes.add(node);
        //         node = node.next;
        //     }
        // }
        // return null;
    }
}