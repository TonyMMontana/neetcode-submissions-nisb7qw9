class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefSum = 0;
        int res = 0;

        for(int num : nums) {
            prefSum += num;
            int diff = prefSum - k;
            res += map.getOrDefault(diff, 0);
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }
        return res;
    }
}