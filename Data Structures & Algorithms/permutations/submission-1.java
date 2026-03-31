class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int i) {
        if(i >= nums.length) {
            List<Integer> perm = new ArrayList<>();
            for(int n : nums) {
                perm.add(n);
            }
            res.add(perm);
            return;
        }

        for(int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            dfs(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
