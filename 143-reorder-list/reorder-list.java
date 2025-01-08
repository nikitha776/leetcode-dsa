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
    public void reorderList(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        int n = 0;
        while(temp != null) {
            st.push(temp.val);
            n++;
            temp = temp.next;
        }
        temp = head;
        ListNode x = head;
        for(int i = 0;i < n/2;i++) {
            ListNode newNode = new ListNode(st.pop());
            newNode.next = temp.next;
            temp.next = newNode;
            x = temp.next;
            temp = temp.next.next;
        }
        if(n % 2 == 0) x.next = null;
        else temp.next = null;
    }
}