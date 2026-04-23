class Solution {
    int[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        cache = new int[s1.length() + 1][s2.length() + 1];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }    
        return dfs(s1, s2, s3, 0, 0) >= 1;
    }

    private int dfs(String s1, String s2, String s3, int idx1, int idx2) {
        if(idx1 + idx2 >= s3.length()) {
            return 1;
        }
        if(cache[idx1][idx2] != -1) {
            return cache[idx1][idx2];
        }
        //go bottom and go right cells
        int take1 = 0;
        int take2 = 0;
        if(idx1 < s1.length() && s3.charAt(idx1 + idx2) == s1.charAt(idx1)) {
            take1 =  dfs(s1, s2, s3, idx1 + 1, idx2);
        } 
        if(idx2 < s2.length() && s3.charAt(idx1 + idx2) == s2.charAt(idx2)) {
            take2 = dfs(s1, s2, s3, idx1, idx2 + 1);
        }
        return cache[idx1][idx2] = take1 == 1 || take2 == 1 ? 1: 0;
    }
}
