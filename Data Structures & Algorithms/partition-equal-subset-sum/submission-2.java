class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if(sum % 2 != 0) return false;

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for(int i = 0; i < nums.length; i++) {
            for(int j = dp.length - 1; j >= nums[i]; j--) {
                if(j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
