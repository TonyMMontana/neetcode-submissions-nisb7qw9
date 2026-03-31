class Solution {
    public int findMin(int[] nums) {
        //integer min value = min to return 
        // i need to undestand based on the nums.legnth , nums[i] how many times nums was rotated and calculate the position 
        //of the element which was at nums[0]

        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}
