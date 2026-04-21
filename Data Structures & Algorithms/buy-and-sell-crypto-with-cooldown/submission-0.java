class Solution {
    int cache[][];
    public int maxProfit(int[] prices) {
        cache = new int[prices.length][2];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return dfs(prices, 0, 1);
    }

    private int dfs(int[] prices, int idx, int canBuy) {
        if(idx >= prices.length) {
            return 0;
        }
        if(cache[idx][canBuy] != -1) {
            return cache[idx][canBuy];
        }
       
        if(canBuy == 1) {
            int take = -prices[idx] + dfs(prices, idx + 1, 0);
            int skip = dfs(prices, idx + 1, 1);
            return cache[idx][canBuy] = Math.max(take, skip);
        } else {
            int take = prices[idx] + dfs(prices, idx + 2, 1);
            int skip = dfs(prices, idx + 1, 0);
            return cache[idx][canBuy] = Math.max(take, skip);
        }
    }
}
