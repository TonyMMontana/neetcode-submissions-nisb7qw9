class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += expand(i, i, s);
            count += expand(i, i+1, s);
        }    
        return count;
    }
    
    private int expand(int l, int r, String s) {
        int res = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            res++;
        }
        return res;
    }

}
