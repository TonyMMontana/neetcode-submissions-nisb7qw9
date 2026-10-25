class LRUCache {
    Node top;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        top = new Node(null, null, 0, 0);
        tail = new Node(top, null, 0, 0);
        top.next = tail;
        map = new HashMap<>();
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
            remove(map.get(key));
            map.remove(key);
        }
        Node node = new Node(null, null, key, value);
        insert(node);
        map.put(key, node);
        if(map.size() > capacity) {
            Node removed = remove(tail.prev);
            map.remove(removed.key);
        }
    }

    private Node insert(Node node) {
        Node prevNext = top.next;
        top.next = node;
        node.prev = top;
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

    private class Node {
        Node next;
        Node prev;
        int val;
        int key;

        public Node(Node prev, Node next, int key, int val) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }
}
