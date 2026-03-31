class Solution {
    public boolean isValid(String s) {
        if(s.length()% 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            } else {
                switch(s.charAt(i)){
                    case ')':
                        if(stack.isEmpty() || stack.peekFirst() != '(') return false;
                        stack.pop();
                        break;
                    case ']':
                        if(stack.isEmpty() || stack.peekFirst() != '[') return false;
                        stack.pop();
                        break;

                    case '}':
                        if(stack.isEmpty() || stack.peekFirst() != '{') return false;
                        stack.pop();
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
