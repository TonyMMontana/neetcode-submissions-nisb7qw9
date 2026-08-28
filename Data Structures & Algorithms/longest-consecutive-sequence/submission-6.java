class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int cur = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            while(i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                cur++;
                i++;
                
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            max = Math.max(max, cur);
            cur = 1;
        }

        return max;
    }
}
