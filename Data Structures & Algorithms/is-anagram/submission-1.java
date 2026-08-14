class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] first = new int[26];
        int[] second = new int[26];

        for(int i = 0; i < s.length(); i++) {
            first[s.charAt(i) - 'a']++;
            second[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }
}
