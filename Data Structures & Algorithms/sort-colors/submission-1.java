class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while(i <= r) {
            if(nums[i] == 0) {
                swap(nums, l, i);
                l++;
                i++;
            } else if(nums[i] == 2 && i < r) {
                swap(nums, r, i);
                r--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}