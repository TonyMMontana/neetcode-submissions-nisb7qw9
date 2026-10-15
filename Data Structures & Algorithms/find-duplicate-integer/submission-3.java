class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }

        int start = 0;

        while(start != slow) {
            slow = nums[slow];
            start = nums[start];
        }

        return start;
    }
}
