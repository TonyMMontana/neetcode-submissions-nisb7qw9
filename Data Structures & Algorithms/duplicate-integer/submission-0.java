class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            set.add(i);
        }

        return nums.length != set.size();
    }
}