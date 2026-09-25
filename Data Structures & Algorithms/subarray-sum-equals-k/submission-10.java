class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int l = 0;
        int r = 0;
        int sum = 0;
        int res = 0;

        while(r < nums.length) {
            sum += nums[r];
            int diff = sum - k;
            res += map.getOrDefault(diff, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);    
            r++;
        }

        return res;
    }
}