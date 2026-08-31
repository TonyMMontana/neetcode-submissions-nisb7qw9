class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int max = 0;

        for(int num : set) {
            if(!set.contains(num - 1)) {
                //start of the seq
                int seq = 1;
                while(set.contains(num + 1)) {
                    seq++;
                    num++;
                }
                max = Math.max(max, seq);
            }
        }

        return max;
    }
}
