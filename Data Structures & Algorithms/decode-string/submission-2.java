class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strs = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int number = 0;

        for(int i = 0; i  <s.length(); i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) {
                number = number * 10 + cur - '0';
            } else if(cur == '[') {
                //save work
                nums.push(number);
                strs.push(sb);

                number = 0;
                sb = new StringBuilder();
            } else if(cur == ']') {
                //get saved work and populate cur to the done.
                StringBuilder prev = strs.pop();
                int times = nums.pop();

                String repeated = sb.toString();
                for(int j = 0; j < times; j++) {
                    prev.append(repeated);
                }
                sb = prev;
            } else {
                sb.append(cur);        
            }
        }
        return sb.toString();
    }
}