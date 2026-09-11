class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;

        int freq = 0;
        int maxLength = 0;
        while(r < s.length()) {
            char curChar = s.charAt(r);
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
            freq = Math.max(freq, map.getOrDefault(curChar, 0));
            while(r - l + 1 - k > freq) {
                //move l
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
