class LRUCache {
    Map<Integer, Node> map;
    Node tail;
    Node start;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        start = new Node(0,0,null, null);
        tail = new Node(0,0, start, null);
        start.next = tail;
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

        Node node = new Node(key, value, null, null);
        insert(node);
        map.put(key, node);

        if(map.size() > capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
    }

    private Node insert(Node node) {
        Node prevNext = start.next;
        start.next = node;
        node.prev = start;
        node.next = prevNext;
        prevNext.prev = node;
        return node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    private class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
