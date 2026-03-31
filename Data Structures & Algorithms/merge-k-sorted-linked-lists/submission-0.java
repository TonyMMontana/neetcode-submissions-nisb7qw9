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
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        PriorityQueue<ListNode> deque = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        //for each linked list in the array
        for(int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while(node != null) {
                deque.add(node);
                node = node.next;
            }
        }
        while(!deque.isEmpty()) {
            cur.next = deque.poll();
            cur = cur.next;
        }
        return dummy.next;
    }
}
