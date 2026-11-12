class LRUCache {
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(null, null, null, null);
        tail = new Node(head, null, null, null);
        head.next = tail;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            map.remove(key);
        }

        Node node = new Node(null, null, key, value);
        insert(node);
        map.put(key, node);

        if(map.size() > capacity) {
            Node removed = map.remove(tail.prev.key);
            remove(removed);
        }
    }

    private Node insert(Node node) {
        Node prevNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = prevNext;
        prevNext.prev = node;
        return node;
    }

    private Node remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
        return node;
    }

    private class Node{
        Node next;
        Node prev;
        Integer val;
        Integer key;

        public Node(Node prev, Node next, Integer key, Integer val) {
            this.prev= prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }
}
