class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(cur == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if(cur == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }
}
