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
    public ListNode reverseKGroup(ListNode head, int k) {
        //int counter
        //create new head == dummy;
        //while(head != null)

        //create new linked list from curernt and counter-node -> while(counter != 0) {counter --; head = head.next;)}
        //reversed = reverse(head)
        //dummy.next += reversed linked list


        ListNode dummy = new ListNode(0,head);
        ListNode groupPrev= dummy;
        
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while(curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
