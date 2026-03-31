class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;   
    }

    private void dfs(int[] candidates, int target, int i, List<Integer> combination, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(combination));
        }
        for(int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            if(sum + candidates[j] > target) {
                break;
            }

            combination.add(candidates[j]);
            dfs(candidates, target, j + 1, combination, sum + candidates[j]);
            combination.remove(combination.size() - 1);
        }

    }
}
