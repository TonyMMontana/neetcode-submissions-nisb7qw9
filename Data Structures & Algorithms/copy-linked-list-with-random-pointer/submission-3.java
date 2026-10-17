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

        Node dummy = new Node(0);
        cur = dummy;

        while(head != null) {
            Node copy = map.get(head);
            copy.random = map.get(head.random);
            cur.next = copy;
            cur = cur.next;
            head = head.next;
        }

        return dummy.next;
    }
}
