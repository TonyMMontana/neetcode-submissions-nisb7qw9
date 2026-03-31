class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int max = 0;

        while(r < prices.length){
            max = Math.max(max, prices[r] - prices[l]);
            if(prices[r] < prices[l]){
                l = r;
            }
            r++;
        }

        return max;
    }
}
