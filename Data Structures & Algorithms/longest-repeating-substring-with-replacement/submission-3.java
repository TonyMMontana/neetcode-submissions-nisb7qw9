class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 1;
        int l = 0;
        int r = 0;

        while(r < s.length()) {
            Character cur = s.charAt(r);

            map.put(cur, map.getOrDefault(cur, 0) + 1);
            maxFreq = Math.max(maxFreq, map.getOrDefault(cur, 0));

            while(r - l + 1 - maxFreq > k) {
                Character leftChar = s.charAt(l);
                map.put(leftChar, map.getOrDefault(leftChar, 1) - 1);
                l++;
            }
            
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
