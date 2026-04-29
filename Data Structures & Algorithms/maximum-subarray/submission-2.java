class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(cur + n < n) {
                cur = n;
            } else {
                cur += n;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
