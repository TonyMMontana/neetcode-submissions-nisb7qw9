class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            //start of the sequence
            int seq = 1;
            if(!set.contains(nums[i] - 1)) {
                int start = nums[i];
                while(set.contains(start + 1)) {
                    seq++;
                    start++;
                }
                res = Math.max(seq, res);
            }
        }

        return res;
    }
}
