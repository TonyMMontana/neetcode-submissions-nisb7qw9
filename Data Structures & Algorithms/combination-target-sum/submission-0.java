class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, target, 0, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> combination, int sum) {
        if(i >= nums.length || sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList(combination));
            return;
        }

        combination.add(nums[i]);
        sum += nums[i];
        dfs(nums, target, i, combination, sum);
        combination.remove(combination.size() - 1);
        sum -= nums[i];
        dfs(nums, target, i + 1, combination, sum);
    }
}
