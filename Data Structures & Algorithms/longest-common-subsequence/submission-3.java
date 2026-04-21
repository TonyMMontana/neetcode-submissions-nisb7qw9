class Solution {
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] mem : memo) {
            Arrays.fill(mem, -1);
        }    

        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int first, int second) {
        if(first >= text1.length() || second >= text2.length()) {
            return 0;
        }
        if(memo[first][second] != -1) {
            return memo[first][second];
        }
        if(text1.charAt(first) == text2.charAt(second)) {
            return memo[first][second] = dfs(text1, text2, first + 1, second + 1) + 1;
        }
        int take = dfs(text1, text2, first + 1, second);
        int skip = dfs(text1, text2, first, second + 1);
        return memo[first][second] = Math.max(take, skip);
    }
}
