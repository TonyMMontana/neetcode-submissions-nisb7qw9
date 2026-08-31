class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int l = 0;
        int r = 0;

        while(r < nums.length) {
            if(nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l + 1;
    }
}