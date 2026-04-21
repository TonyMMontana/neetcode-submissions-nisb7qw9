class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        dp[text2.length()] = 0;
        for(int i = text1.length() - 1; i >= 0; i--) {
            int prev = 0;
            for(int j = text2.length() - 1; j >=0; j--) {
                int tmp = dp[j];
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }
                prev = tmp;
            }
        }
        return dp[0];
    }
}
