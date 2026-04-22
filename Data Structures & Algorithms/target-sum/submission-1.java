class Solution {
    int[][] cache;

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        cache = new int[nums.length][sum * 2 + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }    
        return dfs(nums, target, 0, sum);
    }

    private int dfs(int[] nums, int target, int idx, int sum) {
        if(Math.abs(target) > sum) {
            return 0;
        }
        if(idx == nums.length) {
            return target == 0 ? 1 : 0;
        }
   
        int sumIdx = target + sum;
        if(cache[idx][sumIdx] != -1) {
            return cache[idx][sumIdx];
        }

        int sumRes = dfs(nums, target + nums[idx], idx + 1, sum);
        int substractRes = dfs(nums, target - nums[idx], idx + 1, sum);
        return cache[idx][sumIdx] =  sumRes + substractRes;
    }
}
