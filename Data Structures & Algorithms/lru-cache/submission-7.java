class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        left = new Node(0, 0, null, null);
        right = new Node(0, 0, left, null);
        left.next = right;
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

        while(map.size() > capacity) {
            Node removed = map.remove(right.prev.key);
            remove(removed);
        }
    }

    private Node remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        return node;
    }

    private Node insert(Node node) {
        Node tmp = left.next;
        left.next = node;
        node.prev = left;

        node.next = tmp;
        tmp.prev = node;
        return node;
    }

    private class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
