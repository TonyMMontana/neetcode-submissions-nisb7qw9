class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int index = 0;
        for (int n : nums) {
            if (map.containsKey(target - n)) {
                return new int[]{map.get(target - n), index};
            }
            map.put(n, index);
            index++;
        }
        return new int[2];
    }
}
