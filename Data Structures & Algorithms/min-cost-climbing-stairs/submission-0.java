class Solution {
    int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        for(int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int idx) {
        if(idx >= cost.length) {
            return 0;
        }
        if(cache[idx] != -1) {
            return cache[idx];
        }
        return cache[idx] = cost[idx] 
            + Math.min(dfs(cost, idx + 1), dfs(cost, idx + 2));
    }
}
