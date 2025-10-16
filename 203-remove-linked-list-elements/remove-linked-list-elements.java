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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) return null;
        ListNode temp = head;
        ListNode temp2 = head;
        while(temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp2 = temp;
                temp = temp.next;
            }
        }
        if(temp.val == val) temp2.next = null;
        return head;
    }
}