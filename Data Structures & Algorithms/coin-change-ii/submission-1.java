class Solution {
    int[][] cache;
    public int change(int amount, int[] coins) {
        cache = new int[coins.length][amount + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return dfs(coins, amount, 0);
    }

    private int dfs(int[] coins, int amount, int idx) {
        if(idx >= coins.length || amount < 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        if(cache[idx][amount] != -1) {
            return cache[idx][amount];
        }

        int take = dfs(coins, amount - coins[idx], idx);
        int skip = dfs(coins, amount, idx + 1);
        return cache[idx][amount] = take + skip;
    }
}
