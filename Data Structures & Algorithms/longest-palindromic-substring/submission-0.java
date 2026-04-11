class Solution {
    String res;

    public String longestPalindrome(String s) {
        res = "";
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
        if(s.charAt(l) != s.charAt(r)) {
            return false;
        }
        return isPal(l + 1, r - 1, s);
    }
}
