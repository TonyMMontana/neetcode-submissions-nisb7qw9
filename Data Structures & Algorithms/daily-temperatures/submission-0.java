class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();//[temp, index];
        int[] result = new int[temperatures.length];

        for(int i =0; i < temperatures.length;i++) {
            if(!stack.isEmpty()) {
                //count indeces
                int days = 0;
                while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                    int targetIndex = stack.peek()[1];
                    stack.pop();
                    days = i - targetIndex;
                    result[targetIndex] = days;
                }
            }
            stack.push(new int[] {temperatures[i], i});
        }
        return result;
    }
}
