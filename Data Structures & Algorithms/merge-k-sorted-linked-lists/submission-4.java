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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return mergeRange(0, lists.length - 1, lists);
    }

    private ListNode mergeRange(int start, int end, ListNode[] lists) {
        if(start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;

        ListNode leftSide = mergeRange(start, mid, lists);
        ListNode rightSide = mergeRange(mid + 1, end, lists);
        ListNode mergedList = mergeSortedLists(leftSide, rightSide);
        return mergedList;
    }

    private ListNode mergeSortedLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(left != null || right != null) {
            if(left != null && right != null) {
                if(left.val <= right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }

            } else if(left != null) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
