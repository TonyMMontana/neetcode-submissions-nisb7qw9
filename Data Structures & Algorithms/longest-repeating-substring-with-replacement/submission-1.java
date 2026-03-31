class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        int frequency = 0;

        while(r < s.length()){
            Character current = s.charAt(r);
            map.put(current, map.getOrDefault(current, 0) + 1);
            frequency = Math.max(map.getOrDefault(current, 0), frequency);
            while(r - l + 1 - frequency > k) {
                map.put(s.charAt(l), map.get(s.charAt(l))- 1);
                if(map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }


            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
