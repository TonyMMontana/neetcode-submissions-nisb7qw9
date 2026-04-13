class Solution {
    int[] cache;

    public int numDecodings(String s) {
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(0, s);
    }

    private int dfs(int i, String s) {
        if(i == s.length()) {
            return 1;
        }
        if(s.charAt(i) == '0') {
            return 0;
        }
        if(cache[i] != -1) {
            return cache[i];
        }
        int one = dfs(i + 1, s);
        int two = 0;
        if(i + 1 < s.length()) {
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                two = dfs(i + 2, s);
            }
        }
        return cache[i] = one + two;
    }
}
