class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        char[] targetMap = new char[26];
        char[] sourceMap = new char[26];
        int matches = 0;

        for(int i = 0; i < s1.length(); i++){
            targetMap[s1.charAt(i) - 'a']++;
            sourceMap[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(targetMap[i] == sourceMap[i]){
                matches++;
            }
        }

        if(matches ==26) {
            return true;
        }

        int l = 0;
        int r = s1.length();

        while(r < s2.length()){
            
            if(matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            //move window to right
            sourceMap[index]++;

            //count matches
            if(sourceMap[index] == targetMap[index]) {
                matches++;
            } else if(sourceMap[index] == targetMap[index] + 1 ){
                matches--;
            }

            //move left
            index = s2.charAt(l) - 'a';
            sourceMap[index]--;
            if(sourceMap[index] == targetMap[index]) {
                matches++;
            } else if(sourceMap[index] == targetMap[index] - 1 ){
                matches--;
            }

            l++;
            r++;
        }

        return matches == 26;
    }
}
