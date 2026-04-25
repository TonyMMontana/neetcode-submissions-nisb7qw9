class Solution {
    int[][] cache;
    public int minDistance(String word1, String word2) {
        cache = new int[word1.length() + 1][word2.length() + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int idx1, int idx2) {
        if(idx1 == word1.length()) {
            return cache[idx1][idx2] = word2.length() - idx2;
        }
        if(idx2 == word2.length()) {
            return cache[idx1][idx2] = word1.length() - idx1;
        }
        if(cache[idx1][idx2] != -1) {
            return cache[idx1][idx2];
        }
        if(word1.charAt(idx1) == word2.charAt(idx2)) {
             return cache[idx1][idx2] = dfs(word1, word2, idx1 + 1, idx2 + 1);
        }
        int insert = 1 + dfs(word1, word2, idx1 + 1, idx2 + 1);
        int replace = 1 + dfs(word1, word2, idx1 + 1, idx2);
        int delete = 1 + dfs(word1, word2, idx1, idx2 + 1);

        return cache[idx1][idx2] = Math.min(Math.min(insert, replace), delete);
    }
}
