class LRUCache {
    Node top;
    Node tail;
    Map<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        top = new Node(null, null, 0, 0);
        tail = new Node(top, null, 0, 0);
        top.next = tail;

        cap = capacity;
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
        Node node = new Node(null, null, value, key);
        insert(node);
        map.put(key, node);

        if(map.size() > cap) {
            Node removed = remove(tail.prev);
            map.remove(removed.key);
        }
    }


    private Node insert(Node node) {
        Node prev = top.next;
        top.next = node;
        node.prev = top;
        node.next = prev;
        prev.prev = node;
        return node;
    }

    private Node remove(Node node) {
        Node prev = node.prev;
        node.next.prev = prev;
        prev.next = node.next;
        return node;
    }

    private class Node {
        Node next;
        Node prev;
        int val;
        int key;

        public Node(Node prev, Node next, int val, int key) {
            this.next = next;
            this.prev = prev;
            this.val = val;
            this.key = key;
        }
    }
}
