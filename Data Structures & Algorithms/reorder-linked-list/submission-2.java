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

        //reverse from slow.next since it is point to the mid;

        ListNode prev = null;
        ListNode cur = slow.next;
        slow.next = null;

        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        ListNode left = head;
        ListNode right = prev;
        
        while(right != null) {
            ListNode nextLeft = left.next;
            ListNode nextRight = right.next;

            left.next= right;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }
}
