class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num == 0) {
                max = 1;
                min = 1;
            }

            int tmp = min;
            min = Math.min(Math.min(max * num, min * num), num);
            max = Math.max(Math.max(max * num, tmp * num), num);
            res = Math.max(res, max);
        }
        return res;
    }
}
