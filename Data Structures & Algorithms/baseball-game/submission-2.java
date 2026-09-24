class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String op : operations) {
            if(op.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();

               stack.push(first);
               stack.push(second);
               stack.push(first + second);
            } else if(op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if(op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}