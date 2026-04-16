class Solution {
    int[][] cache;
    public int lengthOfLIS(int[] nums) {
        //bruteforce with dfs
        cache = new int[nums.length][nums.length + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int idx, int prev) {
        if(idx >= nums.length) {
            return 0;
        }
        if(cache[idx][prev + 1] != -1) {
            return cache[idx][prev + 1];
        }
        int skip = dfs(nums, idx + 1, prev);

        int take = 0;
        if(prev == -1 || nums[prev] < nums[idx]){
            take = dfs(nums, idx + 1, idx) + 1;
        }
        
        return cache[idx][prev + 1] = Math.max(take, skip);
    }
}
