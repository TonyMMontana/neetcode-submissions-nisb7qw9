class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(sum + n < n) {
                sum = n;
            } else {
                sum += n;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
