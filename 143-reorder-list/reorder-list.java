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
    public void reorderList(ListNode head) {
        // Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        int n = 0;
        while(temp != null) {
            // st.push(temp.val);
            n++;
            temp = temp.next;
        }
        // temp = head;
        ListNode x = head;
        // for(int i = 0;i < n/2;i++) {
        //     ListNode newNode = new ListNode(st.pop());
        //     newNode.next = temp.next;
        //     temp.next = newNode;
        //     x = temp.next;
        //     temp = temp.next.next;
        // }
        // if(n % 2 == 0) x.next = null;
        // else temp.next = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = head;
        if(n % 2 == 0) head2 = slow;
        else head2 = slow.next;
        ListNode newHead = reverse(head2);
        ListNode tem = head1;
        while(newHead != null) {
            x = newHead.next;
            newHead.next = tem.next;
            tem.next = newHead;
            tem = tem.next.next;
            newHead = x;
        }
        slow.next = null;
    }
}