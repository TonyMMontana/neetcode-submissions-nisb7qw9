class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];

        while(l < r) {
            if(nums[l] < nums[r]) {
                return nums[l];
            }
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[r]) {
                r = mid;
            } else if(nums[mid] > nums[r]) {
                l = mid + 1;
            }
            min = Math.min(min, nums[mid]);
        }
        return nums[l];
    }
}
