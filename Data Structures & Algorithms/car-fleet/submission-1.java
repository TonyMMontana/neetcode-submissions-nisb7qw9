class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> combined = new ArrayList<>();
        for(int i = 0; i< position.length; i++) {
            combined.add(new int[]{position[i], speed[i]});
        }

        combined.sort((a,b) -> a[0] - b[0]);

        Deque<Double> stack = new ArrayDeque<>();

        for(int i = combined.size() - 1; i >= 0; i--){
            double steps = (double) (target - combined.get(i)[0]) / combined.get(i)[1];
            if(stack.isEmpty()) {
                stack.push(steps);
            }
            else if(stack.peek() < steps) {
                stack.push(steps);
            }
        }

        return stack.size();
    }
}
