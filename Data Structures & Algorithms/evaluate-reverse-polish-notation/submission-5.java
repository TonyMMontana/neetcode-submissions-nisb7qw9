class Solution {
    public int evalRPN(String[] tokens) {
        // Deque<String> operations = new ArrayDeque<>();
        Deque<Integer> numbers = new ArrayDeque<>();

        for(String token : tokens) {
            if(token.equals("+")) {
                numbers.push(numbers.pop() + numbers.pop());
            } else if(token.equals("-")) {
                int second = numbers.pop();
                numbers.push(numbers.pop() - second);
            } else if(token.equals("*")) {
                numbers.push(numbers.pop() * numbers.pop());
            } else if(token.equals("/")) {
                int second = numbers.pop();
                numbers.push(numbers.pop() / second);
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }

        return numbers.pop();
    }
}
