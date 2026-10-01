class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[speed.length][2];
        
        for(int i = 0; i < speed.length; i++) {
            pairs[i][0] = speed[i];
            pairs[i][1] = position[i];
        }

        Arrays.sort(pairs, (a,b) -> b[1] - a[1]);

        Stack<Double> stack = new Stack<>();
        for(int[] pair : pairs) {
            double time = (double) (target - pair[1]) / pair[0];
            if(stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
