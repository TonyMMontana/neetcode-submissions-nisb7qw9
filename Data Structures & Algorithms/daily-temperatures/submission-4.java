class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[1] < cur) {
                int[] pair = stack.pop();
                res[pair[0]] = i - pair[0];
            } 
            stack.push(new int[]{i, cur});
        }
        return res;
    }
}
