class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int end = 0;
        int len = 0;
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            len++;
            if(i == end) {
                res.add(len);
                len = 0;
            }
        }
        return res;
    }
}
