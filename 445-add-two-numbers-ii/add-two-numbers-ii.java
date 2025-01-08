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
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);
        ListNode temp1 = h1;
        ListNode temp2 = h2;
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        int sum = 0;
        int carry = 0;
        while(temp1 != null || temp2 != null) {
            sum = (temp1 != null ? temp1.val : 0) + (temp2 != null ? temp2.val : 0) + carry;
            carry = sum / 10;
            int x = sum % 10;
            ListNode newNode = new ListNode(x);
            temp.next = newNode;
            temp = temp.next;
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 =  temp2.next;
        }
        if(carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        } 
        return reverse(res.next);
    }
}