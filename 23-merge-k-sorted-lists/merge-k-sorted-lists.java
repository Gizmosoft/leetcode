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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Queue<Integer> pq = new PriorityQueue<>();
        for(ListNode list: lists) {
            ListNode head = list;
            while(head != null) {
                pq.offer(head.val);
                head = head.next;
            }
        }

        if(pq.isEmpty()) return null;
        ListNode head = new ListNode(pq.poll());
        ListNode node = head;

        while(!pq.isEmpty()) {
            node.next = new ListNode(pq.poll());
            node = node.next;
        }

        return head;
    }
}