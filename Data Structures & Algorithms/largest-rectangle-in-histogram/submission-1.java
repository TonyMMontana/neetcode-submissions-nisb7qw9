class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        int index = 0;

        for(int i =0; i < heights.length; i++){
            index = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                max = Math.max(max, stack.peek()[1] * (i - stack.peek()[0]));
                index = stack.pop()[0];
            }
            stack.push(new int[]{index, heights[i]});
        }

        while(!stack.isEmpty()) {
            max = Math.max(max, (heights.length - stack.peek()[0]) * stack.pop()[1]);
        }
        return max;
    }
}
