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
        List<ListNode> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head);
            head = head.next;
        }
        int l = 0;
        int r = arr.size() - 1;
        
        while(l < r) {
            ListNode last = arr.get(r);
            arr.get(l).next = last;
            r--;
            l++;
            last.next = arr.get(l);
            arr.get(l).next = null;
        }
    }
}
