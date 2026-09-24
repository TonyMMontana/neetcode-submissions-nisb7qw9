class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[speed.length][2];

        for(int i = 0; i < speed.length; i++) {
            pairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        Stack<Double> stack = new Stack<>();

        for(int i = pairs.length - 1; i >= 0; i--) {
            double time = (double) (target - pairs[i][0]) / pairs[i][1];
            if(stack.isEmpty()) {
                stack.push(time);
            } else if(stack.peek() < time) {
                stack.push(time);
            }
        }
         
        return stack.size();
    }
}
