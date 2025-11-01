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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1);
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        dummy.next = head;
        ListNode temp1 = dummy;
        ListNode temp2 = dummy;
        while(temp1 != null) {
            if(set.contains(temp1.val)) {
                temp2.next = temp1.next;
                temp1 = temp1.next;
            } else {
                temp2 = temp1;
                temp1 = temp1.next;
            }
        }
        return dummy.next;
    }
}