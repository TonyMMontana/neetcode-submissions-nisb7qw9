class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);
        size = 0;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        Node temp = head.next;
        temp.prev = node;
        head.next = node;
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head.next;
            node.prev = head;
        } else {
            node = new Node(key, value, head, head.next);
            size++;
        }
        head.next.prev = node;
        head.next = node;
        map.put(key, head.next);
        
        if (size > capacity) {
            Node temp = tail.prev;
            tail.prev = temp.prev;
            temp.prev.next = tail;
            map.remove(temp.key);
            size--;
        }
    }
    
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node() {
        }

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
