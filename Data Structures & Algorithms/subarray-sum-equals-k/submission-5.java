class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefSum = new HashMap<>();
        int res = 0;
        int pref = 0;
        prefSum.put(0, 1);

        for(int num : nums) {
            pref += num;
            int diff = pref - k;
            res += prefSum.getOrDefault(diff, 0);
            prefSum.put(pref, prefSum.getOrDefault(pref, 0) + 1);
        }
        return res;
    }
}