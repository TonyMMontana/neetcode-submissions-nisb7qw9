class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int idx) {
        if(idx >= nums.length - 1) {
            return true;
        }
        if(nums[idx] == 0) {
            return false;
        }
        boolean res = false;
        for(int i = idx + nums[idx]; i > idx; i--) {
            res = res || dfs(nums, i);
        }
        return res;
    }
}
