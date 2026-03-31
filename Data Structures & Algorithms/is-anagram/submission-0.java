class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            sMap.put(current, sMap.getOrDefault(current, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character current = t.charAt(i);
            tMap.put(current, tMap.getOrDefault(current, 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
