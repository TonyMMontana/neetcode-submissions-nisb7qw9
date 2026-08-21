class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        res[res.length - 1] = 1;
        
        res[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i  - 1];
        }

        int postfix = 1;

        for(int i = res.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}  
