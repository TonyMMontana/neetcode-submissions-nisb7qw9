class MinStack {
    Node top;

    public MinStack() {
        top = new Node(null, null, Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        int min = Math.min(top.minSoFar, val);
        Node node = new Node(val, top, min);
        top = node;
    }
    
    public void pop() {
        top = top.prev;
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.minSoFar;
    }

    private class Node {
        Integer value;
        Node prev;
        int minSoFar;

        public Node(Integer value, Node prev, int minSoFar) {
            this.value = value;
            this.prev = prev;
            this.minSoFar = minSoFar;
        }
    }
}
