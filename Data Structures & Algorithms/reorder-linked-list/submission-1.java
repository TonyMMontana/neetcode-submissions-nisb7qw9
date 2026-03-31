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
        //find the middle
        //reverse right part
        //link left -> right -> left.next & store nodes(left.next; right.next;) remove pointers from left and right

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode reverseHead = slow.next;
        slow.next = null;
        reverseHead = reverse(reverseHead);

        ListNode left = head;
        ListNode right = reverseHead;

        while(right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }

    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverse(head.next);
        head.next.next = head; //4 -> 3 for head = 3 in list 3 -> 4 -> null
        head.next = null;
        return newNode;
    }
}
