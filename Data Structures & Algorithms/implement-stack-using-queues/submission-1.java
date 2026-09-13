class MyStack {
    Queue<Integer> queue;
    Integer top;

    public MyStack() {
        queue = new LinkedList<>();
        top = null;
    }
    
    public void push(int x) {
        queue.offer(x);
        top = x;
    }
    
    public int pop() {
        for(int i = 0; i < queue.size() - 1; i++) {
            top = queue.poll();
            queue.offer(top);
        }
        return queue.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */