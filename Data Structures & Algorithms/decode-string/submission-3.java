class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strs = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) {
                num = num * 10 + cur - '0';
            } else if(cur == '[') {
                strs.push(sb);
                nums.push(num);

                sb = new StringBuilder();
                num = 0;
            } else if(cur == ']') {
                StringBuilder prev = strs.pop();
                int times = nums.pop();
                String prefix = sb.toString();

                for(int j = 0; j < times; j++) {
                    prev.append(prefix);
                }

                sb = prev;
            } else {
                sb.append(cur);
            }
        }

        return sb.toString();
    }
}