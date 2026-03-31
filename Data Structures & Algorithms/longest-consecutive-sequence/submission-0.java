class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        int sequence = 1;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                //create sequence
                while (set.contains(num + 1)) {
                    sequence++;
                    num++;
                }
            }
            result = Math.max(result, sequence);
            sequence = 1;
        }
        return result;
    }
}
