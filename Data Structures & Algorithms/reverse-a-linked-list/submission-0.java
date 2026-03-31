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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        ListNode reverse = new ListNode(list.get(list.size() - 1));
        ListNode result = reverse;
        list.remove(list.size() - 1);
        for(int i = list.size() - 1; i >= 0; i--){
            ListNode node = new ListNode(list.get(i));
            reverse.next = node;
            reverse = node;
        }
        
        return result;
    }
}
