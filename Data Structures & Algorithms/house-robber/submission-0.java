class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            cache[i] = -1;
        }

        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int idx) {
        if(idx >= nums.length) {
            return 0;
        }
        if(cache[idx] != -1) {
            return cache[idx];
        }
        // issue here. i need to undestand how to itterate over each all options except next houses
        cache[idx] =  Math.max(nums[idx] + dfs(nums, idx + 2), dfs(nums, idx + 1));
        return cache[idx];
    }
}
