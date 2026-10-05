class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[l] <= nums[mid]) {
                //left part sorted
                if(nums[l] <= target && nums[mid] > target) {
                    //target inside sorted part
                    r = mid - 1;
                } else {
                    //target inside unsorted part
                    l = mid + 1;
                }
            } else {
                //right part sorted
                if(nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
