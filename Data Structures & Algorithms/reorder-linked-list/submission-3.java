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
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode node = slow.next;
        slow.next = null;

        //reverse from slow.next;

        ListNode prev = null;

        while(node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }

        //merge with prev;
        ListNode cur = head;

        while(prev != null) {
            ListNode curNext = cur.next;
            ListNode prevNext = prev.next;

            cur.next = prev;
            prev.next = curNext;
            
            cur = curNext;
            prev = prevNext;
        }
    }
}
