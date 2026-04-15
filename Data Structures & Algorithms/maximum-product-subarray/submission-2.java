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
            int tmp = min * num;
            min = Math.min(Math.min(num * max, num * min), num);
            max = Math.max(Math.max(num * max, tmp), num);
            res = Math.max(res, max);
        }
        return res;
    }
}
