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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        // ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            int temp = fast.val;
            fast.val = fast.next.val;
            fast.next.val = temp;
            // slow = slow.next.next;
            fast = fast.next.next;
        }
        return head;
    }
}