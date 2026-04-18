class Solution {
    int[][] cache;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if(sum % 2 != 0) return false;

        cache = new int[nums.length][sum / 2 + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return dfs(nums, 0, sum / 2);
    }

    private boolean dfs(int[] nums, int idx, int target) {
        if(target == 0) return true;
        if(idx >= nums.length || target < 0) return false;
        if(cache[idx][target] != -1) {
            return cache[idx][target] == 1;
        }
        boolean take = dfs(nums, idx + 1, target - nums[idx]);
        boolean skip = dfs(nums, idx + 1, target);
        if(take || skip) {
            cache[idx][target] = 1;
        } else {
            cache[idx][target] = 0;
        }
        return take || skip;
    }
}
