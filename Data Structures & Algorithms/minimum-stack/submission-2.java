class MinStack {
    Node top;

    public MinStack() {
        top = new Node(null, null, Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        int min = Math.min(top.minSoFar, val);
        Node node = new Node(top, val, min);
        top = node;
    }
    
    public void pop() {
        top = top.prev;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.minSoFar;
    }

    private class Node {
        Node prev;
        Integer val;
        int minSoFar;

        public Node(Node prev, Integer val, int min) {
            this.prev = prev;
            this.val = val;
            this.minSoFar = min;
        }
    }
}
