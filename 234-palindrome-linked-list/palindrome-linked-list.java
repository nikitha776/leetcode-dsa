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
        ListNode next = curr;
        while(curr !=  null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        // Stack<Integer> st = new Stack<>();
        // ListNode temp = head;
        // while(temp != null) {
        //     st.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp != null && st.pop() == temp.val) {
        //     temp = temp.next;
        // }
        // return temp == null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        while(rev != null) {
            if(rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
}