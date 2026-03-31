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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(1, head);

        ListNode left = dummy;
        ListNode right = dummy;
        ListNode prev = dummy;

        int counter = 0;

        while(right != null) {
            if(counter >= n) {
                prev = left;
                left = left.next;
            }
            right = right.next;
            counter++;
        }
        if(prev != null) {
            prev.next = left.next;
        }

        left = null;
        return dummy.next;
    }

}
