/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        Node copy = map.get(head);
        Node result = copy;
        while(head != null) {
            copy.next = map.get(head.next);
            copy.random = map.get(head.random);
            copy = copy.next;
            head = head.next;
        }
        return result;
    }
}
