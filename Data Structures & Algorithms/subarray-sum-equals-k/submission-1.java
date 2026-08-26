class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i]; 
        }

        int res = 0;
        for(int i = 0; i < prefixSum.length; i++) {
            if(prefixSum[i] == k) {
                res++;
            } 
            for(int start = 0; start < i; start++) {
                if(prefixSum[i] - prefixSum[start] == k) {
                    res++;
                }
            }
        }

        return res;
    }
}