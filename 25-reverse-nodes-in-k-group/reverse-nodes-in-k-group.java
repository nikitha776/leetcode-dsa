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
    public ListNode reverse(ListNode head,int k) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while(k > 0) {
            k--;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode newHead = null;

        int count  = 0;
        while(ptr != null) {
            
            count = 0;
            while(count < k && ptr != null) {
                count++;
                ptr = ptr.next;
            }
            if(count == k) {
                ListNode revHead = reverse(head,k);            
                if(newHead == null) {
                    newHead = revHead;
                }
                if(ktail != null) ktail.next = revHead;
                ktail = head;
                head = ptr;
            }
        }
        if(count < k) {ktail.next = head;}
        return newHead != null ? newHead : head;
    }
}