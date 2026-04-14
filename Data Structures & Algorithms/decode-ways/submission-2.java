class Solution {
    int cache[];

    public int numDecodings(String s) {
        cache = new int[s.length()];   
        Arrays.fill(cache, -1);
        return dfs(s, 0); 
    }

    private int dfs(String s, int i) {
        if(i == s.length()) {
            return 1;
        }
        if(s.charAt(i) == '0') {
            return 0;
        }
        if(cache[i] != -1) {
            return cache[i];
        }
        int one = dfs(s, i + 1);
        int two = 0;
        if(i + 1 < s.length()) {
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                two = dfs(s, i + 2);
            }
        }
        return cache[i] = one + two;
    }
}
