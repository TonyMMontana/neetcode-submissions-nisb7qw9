class Solution {
    int[] cache;
     
    public int climbStairs(int n) {
        cache = new int[n];
        for(int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    private int dfs(int n, int val) {
        if(val > n) {
            return 0;
        }
        if(val == n) {
            return 1;
        }
        if(cache[val] != -1) {
            return cache[val];
        }
        cache[val] = dfs(n, val + 1) + dfs(n, val + 2);
        return cache[val];
    }
}
