class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int size = 0, end = 0;
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            size++;
            if(end == i) {
                res.add(size);
                size = 0;
                continue;
            }
        }
        return res;
    }
}
