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
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        int num = 0;

        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + num;
            if(val >= 10) {
                val %= 10;
                num = 1;
            } else {
                num = 0;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode next = l1 == null ? l2 : l1;
        
        while(next != null) {
            int val = next.val + num;
            if(val >= 10) {
                val %= 10;
                num = 1;
            } else {
                num = 0;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            next = next.next;
        }

        if(next == null && num != 0) {
            cur.next = new ListNode(num);
        }

        return dummy.next;
    }
}
