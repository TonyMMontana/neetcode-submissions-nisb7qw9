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

        int left = 0;

        while(left != slow) {
            left = nums[left];
            slow = nums[slow];
        }

        return left;
    }
}
