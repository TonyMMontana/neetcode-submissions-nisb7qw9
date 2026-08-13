class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int l = 0;
        int r = nums.length;
        while(r < ans.length) {
            ans[l] = nums[l];
            ans[r] = nums[l]; 
            l++;
            r++;
        }
        return ans;
    }
}