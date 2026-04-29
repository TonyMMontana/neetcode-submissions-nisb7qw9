class Solution {
    int[] cache;

    public boolean canJump(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int idx) {
        if(idx >= nums.length - 1) {
            if(idx >= cache.length) {
                cache[cache.length - 1] = 1;
            }
            return true;
        }
        if(nums[idx] == 0) {
            cache[idx] = 0;
            return false;
        }
        if(cache[idx] != -1) {
            return cache[idx] == 1;
        }
        boolean res = false;
        for(int i = idx + nums[idx]; i > idx; i--) {
            res = res || dfs(nums, i);
        }
        cache[idx] = res ? 1 : 0;
        return res;
    }
}
