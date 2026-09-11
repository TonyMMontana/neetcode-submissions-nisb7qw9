class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int pref = 0;
        prefixMap.put(pref, 1);

        int res = 0;

        for(int num : nums) {
            pref += num;
            int diff = pref - k;
            res += prefixMap.getOrDefault(diff, 0);
            prefixMap.put(pref, prefixMap.getOrDefault(pref, 0) + 1);
        }
        return res;
    }
}