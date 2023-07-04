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
    
    public List<Integer> converToArrayList(ListNode head){
        ListNode temp = head;
        List<Integer> list = new ArrayList<Integer>();
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }
    
    public ListNode convertToLL(List<Integer> list){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for(Integer l : list){
            ListNode node = new ListNode(l, null);
            temp.next = node;
            temp = temp.next;
        }
        head = head.next;
        return head;
    }
    
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        
        // convert list to arraylist
        List<Integer> list = converToArrayList(head);
        
        List<Integer> answer = new ArrayList<Integer>();
        for(Integer l : list){
            if(l!=val){
                answer.add(l);
            }
        }
        
        // convert array list to a linked list
        head = convertToLL(answer);
        
        return head;
    }
}