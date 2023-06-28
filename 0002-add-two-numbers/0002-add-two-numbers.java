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
import java.lang.*;
import java.math.BigInteger;

class Solution {
    public BigInteger addNums(StringBuffer num1, StringBuffer num2){
        BigInteger b1 = new BigInteger(num1.toString());
        BigInteger b2 = new BigInteger(num2.toString());
        
        return b1.add(b2);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer firstNum = new StringBuffer("");
        StringBuffer secondNum = new StringBuffer("");
        
        while(l1 != null){
            firstNum.append(l1.val);
            l1 = l1.next;
        } 
        firstNum.reverse();
        
        while(l2 != null){
            secondNum.append(l2.val);
            l2 = l2.next;
        }
        secondNum.reverse();
        
        BigInteger sum = addNums(firstNum, secondNum);
        
        String sum1 = sum.toString();
        
        ListNode head = new ListNode();
        head.next = null;
        ListNode temp = head;
        for(int i=sum1.length()-1; i>=0; i--){
            int s = sum1.charAt(i) - '0';
            ListNode newNode = new ListNode(s, null);
            temp.next = newNode;
            temp = newNode;
        }
        
        return head.next;
        
    }
}