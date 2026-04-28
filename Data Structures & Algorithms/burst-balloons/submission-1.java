class Solution {
    int[][] cache;
    public int maxCoins(int[] nums) {
        int[] copy = new int[nums.length + 2];
        System.arraycopy(nums, 0, copy, 1, nums.length);
        copy[0] = 1;
        copy[copy.length - 1] = 1;

        cache = new int[copy.length + 1][copy.length + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return dfs(1, copy.length - 2, copy);
    }

    private int dfs(int l, int r, int[] copy) {
        if(l > r) {
            return 0;
        }
        if(cache[l][r] != -1) {
            return cache[l][r];
        }

        int max = 0;
        for(int i = l; i <= r; i++) {
            int gain = copy[l - 1] * copy[i] * copy[r + 1];
            int total = gain + dfs(l, i - 1, copy) + dfs(i + 1, r, copy);
            max = Math.max(max, total);
        }
        return cache[l][r] = max;
    }
}
