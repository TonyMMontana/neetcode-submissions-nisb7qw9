class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[t.length()] = 1;

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = 0; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}
