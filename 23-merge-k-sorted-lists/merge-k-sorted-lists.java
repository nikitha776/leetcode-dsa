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
    public ListNode merge(ListNode head1,ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        if(head1 != null) temp.next = head1;
        if(head2 != null) temp.next = head2;
        return head.next;
    }
    public ListNode helper(ListNode[] lists,int left,int right) {
        if(left == right) return lists[left];
        int mid = left+(right-left)/2;
        ListNode l1 = helper(lists,left,mid);
        ListNode l2 = helper(lists,mid+1,right);
        return merge(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists,0,lists.length-1);
    }
}