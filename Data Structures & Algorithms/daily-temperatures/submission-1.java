class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();//[temp, index];
        int[] result = new int[temperatures.length];

        for(int i =0; i < temperatures.length;i++) {
            
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int targetIndex = stack.peek()[1];
                stack.pop();
                int days = i - targetIndex;
                result[targetIndex] = days;
            }

            stack.push(new int[] {temperatures[i], i});
        }
        return result;
    }
}
