class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] grid = new int[speed.length][2];
        for(int i = 0; i < speed.length; i++) {
            grid[i][0] = position[i];
            grid[i][1] = speed[i];
        }

        Arrays.sort(grid, (a,b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();

        for(int[] pair : grid) {
            double time = (double) (target - pair[0]) / pair[1];
            if(stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
