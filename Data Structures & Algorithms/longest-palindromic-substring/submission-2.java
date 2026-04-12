class Solution {
    Map<String, Boolean> cache;

    public String longestPalindrome(String s) {
        String res = "";
        cache = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            for(int r = i; r < s.length(); r++) {
                if(isPal(i, r, s)) {
                    if(res.length() < r - i + 1) {
                        res = s.substring(i, r + 1);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPal(int l, int r, String s) {
        if(l >= r) {
            return true;
        }
        String key = String.valueOf(l) + "," + String.valueOf(r);
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        if(s.charAt(l) != s.charAt(r)) {
            cache.put(key, false);
            return false;
        }
        cache.put(key, isPal(l + 1, r - 1, s));
        return cache.get(key);
    }
}
