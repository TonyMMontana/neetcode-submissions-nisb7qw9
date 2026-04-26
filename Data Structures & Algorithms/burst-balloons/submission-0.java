class Solution {
    int[][] cache;
    public int maxCoins(int[] nums) {
        int[] copy = new int[nums.length + 2];
        copy[0] = 1;
        copy[copy.length - 1] = 1;
        System.arraycopy(nums, 0, copy, 1, nums.length);

        cache = new int[copy.length][copy.length];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return dfs(1, copy.length - 2, copy);
    }

    private int dfs(int left, int right, int[] copy) {
        if(right < left) {
            return 0;
        }
        if(cache[left][right] != -1) {
            return cache[left][right];
        }
        int max = 0;
        for(int i = left; i <= right; i++) {
            int gain = copy[left - 1] * copy[i] * copy[right + 1];
            int total = gain + dfs(left, i - 1, copy) + dfs(i + 1, right, copy);
            max = Math.max(max, total);
        }
        return cache[left][right] = max;
    }
}
