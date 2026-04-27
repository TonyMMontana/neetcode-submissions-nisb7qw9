class Solution {
    int cache[][];
    public boolean isMatch(String s, String p) {
        cache = new int[s.length() + 1][p.length() + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(s, p, 0, 0) >= 1;
    }

    private int dfs(String s, String p, int idx1, int idx2) {
        if(p.length() == idx2) {
            return s.length() == idx1 ? 1 : 0;
        }
        if(cache[idx1][idx2] != -1) {
            return cache[idx1][idx2];
        }

        boolean currentMatch = idx1 < s.length() && (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.');

        if(idx2 + 1< p.length() && p.charAt(idx2 + 1) == '*') {
            int skip = dfs(s, p, idx1, idx2 + 2);
            int takeOne = currentMatch ? dfs(s, p, idx1 + 1, idx2) : 0;
            return cache[idx1][idx2] = skip == 1 || takeOne == 1 ? 1 : 0;
        }
        if(currentMatch) {
               return cache[idx1][idx2] = dfs(s, p, idx1 + 1, idx2 + 1);
        }
        
        return cache[idx1][idx2] = 0;
    }
}
