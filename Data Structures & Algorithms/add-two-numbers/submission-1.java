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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode cur = new ListNode();
        ListNode result = cur;
        int remember = 0;

        while (first != null || second != null || remember != 0) {
            int val = 0;
            if(first != null) {
                val += first.val;
            }
            if (second != null) {
                val += second.val;
            }
            if(remember != 0) {
                val += remember;
                remember = 0;
            }
            if(val >= 10) {
                remember = 1;
                val -= 10;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
           
            first = first == null ? null : first.next;
            second = second == null ? null : second.next;
        }
        return result.next;
    }
}
