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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevNode = null;
        ListNode cur = dummy;

        for(int i = 0; i < left; i++) {
            prevNode = cur;
            cur = cur.next;
        }

        //reverse
        ListNode prev = null;

        for(int i = 0; i < right - left + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        prevNode.next.next = cur;
        prevNode.next = prev;
        

        return dummy.next;
    }
}