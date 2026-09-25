class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] first = new int[26];
        int[] second = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            first[s1.charAt(i) - 'a']++;
            second[s2.charAt(i) - 'a']++;
        }

        int match = 0;

        for(int i = 0; i < 26; i++) {
            if(first[i] == second[i]) {
                match++;
            }
        }

        int l = 0;
        int r = s1.length();

        while(r < s2.length()) {
            if(match == 26) {
                return true;
            }
            int idx = s2.charAt(r) - 'a';
            second[idx]++;
            if(first[idx] == second[idx]) {
                match++;
            } else if(first[idx] == second[idx] - 1) {
                match--;
            }
            r++;

            idx = s2.charAt(l) - 'a';
            second[idx]--;
            if(first[idx] == second[idx]) {
                match++;
            } else if(first[idx] == second[idx] + 1) {
                match--;
            }
            l++;
        }
        return match == 26;
    }
}
