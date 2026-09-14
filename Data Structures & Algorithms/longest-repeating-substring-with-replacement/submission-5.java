class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map  = new HashMap<>();
        
        int maxFreq = 0;
        int maxLength = 0;
        int l = 0;
        int r = 0;

        while(r < s.length()) {
            char right = s.charAt(r);
            map.put(right, map.getOrDefault(right, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(right));
            if(maxFreq + k < r - l + 1) {
                char left = s.charAt(l);
                map.put(left, map.getOrDefault(left, 1) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
