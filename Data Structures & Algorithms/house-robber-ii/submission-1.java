class Solution {

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] cacheA = new int[nums.length];
        Arrays.fill(cacheA, -1);
        int[] cacheB = new int[nums.length];
        Arrays.fill(cacheB, -1);

        return Math.max(dfs(nums, 0, nums.length - 2, cacheA), dfs(nums, 1, nums.length - 1, cacheB));
    }

    private int dfs(int[] nums, int idx, int end, int[] cache) {
        if(idx > end) {
            return 0;
        }
        if(cache[idx] != -1) {
            return cache[idx];
        }
        
        cache[idx] =  Math.max(nums[idx] + dfs(nums, idx + 2, end, cache), dfs(nums, idx + 1, end, cache));
        return cache[idx];
    }
}
