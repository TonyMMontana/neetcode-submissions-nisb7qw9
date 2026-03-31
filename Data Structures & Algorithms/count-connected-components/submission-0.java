class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    int res = 0;

    public int countComponents(int n, int[][] edges) {
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], k ->  new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k ->  new ArrayList<>()).add(edge[0]);
        }

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int node) {
        if(visited.contains(node)){
            return;
        }
        if(map.get(node) == null || map.get(node).isEmpty()) {
            return;
        }
        visited.add(node);
        for(int i : map.get(node)) {
            dfs(i);
        }
    }
}
