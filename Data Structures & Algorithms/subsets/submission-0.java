class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        dfs(nums, 0, new ArrayList<>(), new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> include, List<Integer> exclude) {
        if(i >= nums.length) {
            return;
        }
        
        include.add(nums[i]);
        res.add(include);

        dfs(nums, i + 1, new ArrayList<>(include),  new ArrayList<>(exclude));
        dfs(nums, i + 1,new ArrayList<>(exclude),  new ArrayList<>(include));
    }

}
