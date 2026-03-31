class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> subset, int i) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, subset, i + 1);
        while(i < nums.length - 1 && nums[i] == nums[i+1]) {
            i++;
        }
        subset.remove(subset.size() - 1);
        dfs(nums, subset, i + 1);
    }
}
