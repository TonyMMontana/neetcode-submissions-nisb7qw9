class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;

        for(int num : set) {
            //start of the sequence
            int seq = 1;
            if(!set.contains(num - 1)) {
                while(set.contains(num + 1)) {
                    seq++;
                    num++;
                }
                res = Math.max(seq, res);
            }
        }

        return res;
    }
}
