class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            targetMap.put(s1.charAt(i), targetMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        Map<Character, Integer> sourceMap = new HashMap<>();

        while(r < s2.length()){
            if(r >= s1.length()){
                //l++ use fix sized window
                sourceMap.put(s2.charAt(l), sourceMap.get(s2.charAt(l)) - 1);
                if(sourceMap.get(s2.charAt(l)) == 0){
                    sourceMap.remove(s2.charAt(l));
                }
                l++;
            }
            sourceMap.put(s2.charAt(r), sourceMap.getOrDefault(s2.charAt(r), 0) + 1);
            if(sourceMap.equals(targetMap)){
                    return true;
                }
            r++;
        }

        return false;
    }
}
