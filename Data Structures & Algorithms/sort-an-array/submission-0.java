class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(compare(nums[i], nums[j])) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    private boolean compare(int a, int b) {
        return a - b > 0;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}