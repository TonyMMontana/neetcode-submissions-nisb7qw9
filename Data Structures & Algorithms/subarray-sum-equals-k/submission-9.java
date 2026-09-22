class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int r = 0;
        int res = 0;

        int pref = 0;

        while(r < nums.length) {
            pref += nums[r];
            int key = pref - k;
            res += map.getOrDefault(key, 0);
            map.put(pref, map.getOrDefault(pref, 0) + 1);
            r++;
        }
        return res;
    }
}