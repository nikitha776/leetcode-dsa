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
    public ListNode removeNodes(ListNode head) {
        ListNode newHead = reverse(head);
        int max = newHead.val;
        ListNode temp2 = newHead.next;
        ListNode x = new ListNode(max);
        ListNode temp1 = x;
        while(temp2 != null) {
            if(temp2.val >= max) {
                ListNode newNode = new ListNode(temp2.val);
                x.next = newNode;
                x = newNode;
                max = temp2.val;
            }
            temp2 = temp2.next;
        }
        newHead = reverse(temp1);
        return newHead;
    }
}