class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int freq = 0;

        int l = 0;
        int r = 0;
        while(r < s.length()) {
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            freq = Math.max(freq, map.get(cur));

            while(r - l + 1 - freq > k) {
                char left = s.charAt(l);
                map.put(left, map.getOrDefault(left, 1) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
