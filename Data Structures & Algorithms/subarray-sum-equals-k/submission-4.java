class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cur = 0;

        for(int i = 0; i < nums.length; i++){
            cur += nums[i];
            res += map.getOrDefault(cur - k, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return res;
    }
}