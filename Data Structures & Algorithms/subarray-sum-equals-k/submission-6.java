class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int prefixSum = 0;
        map.put(0, 1);

        for(int i =0; i < nums.length; i++) {
            prefixSum += nums[i];
            int key = prefixSum - k;
            res += map.getOrDefault(key, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}