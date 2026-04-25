class Solution {
    int cache[][];

    public int numDistinct(String s, String t) {
        cache = new int[s.length()][t.length()];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }     
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int idx, int depth) {
        if(depth == t.length()) {
            return 1;
        }
        if(idx == s.length()) {
            return 0;
        }
        if(cache[idx][depth] != -1) {
            return cache[idx][depth];
        }

        int take = 0;
        int skip = 0;

        if(s.charAt(idx) == t.charAt(depth)) {
            take = dfs(s, t, idx + 1, depth + 1);
        }
        skip = dfs(s, t, idx + 1, depth); 
        return cache[idx][depth] = take + skip;
    }
}
