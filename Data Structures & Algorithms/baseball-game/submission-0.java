class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String operation : operations) {
            if(operation.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                int sum = first + second;
                stack.push(first);
                stack.push(second);
                stack.push(sum);
            } else if(operation.equals("D")) {
                int prev = stack.peek();
                stack.push(2 * prev);
            } else if(operation.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}