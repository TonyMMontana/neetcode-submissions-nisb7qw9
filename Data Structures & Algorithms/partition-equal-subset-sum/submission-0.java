class Solution {
    int cache[][];

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if(sum % 2 != 0) {
            return false;
        }

        cache = new int[nums.length][sum / 2 + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return dfs(0, sum / 2, nums);
    }

    private boolean dfs(int idx, int target, int[] nums) {
        if(target < 0 || idx >= nums.length) {
            return false;
        }
        if(target == 0) {
            return true;
        }
        if(cache[idx][target] != -1) {
            return cache[idx][target] == 1;
        }
        boolean take = dfs(idx + 1, target - nums[idx], nums);
        boolean skip = dfs(idx + 1, target, nums);
        if(take || skip) {
            cache[idx][target] = 1;
        } else {
            cache[idx][target] = 0;
        }
        return cache[idx][target] == 1;
    }
}
