class Solution {
    int[][] cache;

    public int longestCommonSubsequence(String text1, String text2) {
        cache = new int[text1.length()][text2.length()];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int first, int second) {
        if(first >= text1.length() || second >= text2.length()) {
            return 0;
        }
        if(cache[first][second] != -1) {
            return cache[first][second];
        }
        if(text1.charAt(first) == text2.charAt(second)) {
            return cache[first][second] = dfs(text1, text2, first + 1, second + 1) + 1;
        }
        return cache[first][second] = Math.max(dfs(text1, text2, first + 1, second),
                                        dfs(text1, text2, first, second + 1));
    }
}
