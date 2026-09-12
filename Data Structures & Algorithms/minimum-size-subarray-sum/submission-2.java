class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;

        while(r < nums.length) {
            sum += nums[r];
            while( sum >= target) {
                min = Math.min(r - l + 1, min);
                sum -= nums[l];
                l++;
            }    
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}