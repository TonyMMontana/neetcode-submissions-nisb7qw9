class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int j = 0; j < m - 1; j++) {
            for(int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i];
            }
        }
        return dp[0];
    }
}
