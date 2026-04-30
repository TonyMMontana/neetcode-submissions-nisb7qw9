class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int res = 0;

        while(r < nums.length - 1) {
            int furthest = l;
            for(int i = l; i <= r; i++) {
                furthest = Math.max(furthest, nums[i] + i);
            }
            l = r;
            r = furthest;
            res++;
        }
        return res;
    }
}
