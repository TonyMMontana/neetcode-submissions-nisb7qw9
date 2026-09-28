class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[speed.length][2];

        for(int i = 0; i < position.length; i++) {
            pairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        int fleet = 0;
        double maxTime = 0;
        for(int[] pair : pairs) {
            double time = (double) (target - pair[0]) / pair[1];
            if(maxTime < time) {
                fleet++;
                maxTime = time;
            }
        }

        return fleet;
    }
}
