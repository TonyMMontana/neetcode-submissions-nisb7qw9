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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        ListNode prev = null; 

        while(right != null) {
            ListNode tmp = right.next;
            right.next = prev;
            prev = right;
            right = tmp;
        }

        right = prev;
        ListNode cur  = head;

        while(right != null) {
            ListNode curNext = cur.next;
            ListNode rightNext = right.next;

            cur.next = right;
            right.next= curNext;

            cur = curNext;
            right = rightNext;
        }
    }
}
