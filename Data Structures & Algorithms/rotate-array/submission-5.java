class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int l = 0;
        int r = nums.length - 1;

        reverse(nums, l, r);
        reverse(nums, k, r);
        reverse(nums, l, k - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while(l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}