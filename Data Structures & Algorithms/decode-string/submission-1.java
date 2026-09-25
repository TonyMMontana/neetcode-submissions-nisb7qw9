class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();

        int num = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) {
                num = num * 10 + (cur - '0');
            } else if (cur == '[') {
                nums.push(num);
                strs.push(sb);

                num = 0;
                sb = new StringBuilder();
            } else if(cur == ']') {
                int times = nums.pop();
                StringBuilder prev = strs.pop();

                String sub = sb.toString();
                for(int j = 0; j < times; j++) {
                    prev.append(sub);
                }
                sb = prev;
            } else {
                sb.append(cur);
            }    
        }

        return sb.toString();
    }
}