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
    public ListNode merge(ListNode left,ListNode right) {
        ListNode temp1 = left;
        ListNode temp2 = right;
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        while(temp1 != null && temp2 != null) {
            if(temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = (temp1 != null) ? temp1 : temp2;
        return dummy.next;
    }

    public ListNode divide(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = divide(head);
        ListNode right = divide(mid);
        return merge(left,right);
    }
    public ListNode sortList(ListNode head) {
        return divide(head);
    }
}