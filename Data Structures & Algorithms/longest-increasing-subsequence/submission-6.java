class Solution {

    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            dp[i] = 1;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
