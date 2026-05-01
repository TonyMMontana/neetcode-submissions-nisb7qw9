class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int diff = 0;
        int idx = 0;

        for(int i =0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
            if(tank + gas[i] < cost[i]) {
                tank = 0;
                idx = i + 1;
                continue;
            }
            tank += gas[i] - cost[i];
        }
        return diff >= 0 ? idx : -1;
    }
}
