class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(int i : set) {
            if(!set.contains(i  -1)) {
                int sequence = 1;
                while(set.contains(i + 1)) {
                    sequence++;
                    i++;
                }
                result = Math.max(result, sequence);
            }
        }
        return result;
    }
}
