class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        int sum = 0;
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                sum = apply(token, stack);
                stack.push(sum);
            }
        }
        return stack.pop();
    }

    private int apply(String token, Deque<Integer> stack) {
        
        int second = stack.pop();
        int sum = stack.pop();
        switch (token) {
            case "+" -> {
                return sum + second;
            }
            case "-" -> {
                return sum - second;
            }
            case "*" -> {
                return sum * second;
            }
            case "/" -> {
                return sum / second;
            }
        }

        return sum;
    }
}
