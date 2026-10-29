class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];

        for(int i = 0; i < speed.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        for(int[] pair : pairs) {
            double curTime = (double) (target - pair[0]) / pair[1];
            if(stack.isEmpty() || stack.peek() < curTime) {
                stack.push(curTime);
            }
        }

        return stack.size();

    }
}
