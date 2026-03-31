class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        if(!dfs(0, -1)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean dfs(int node, int parrent) {
        visited.add(node);
        for(int i : map.getOrDefault(node, new ArrayList<>())) {
            if(i == parrent) {
                continue;
            }
            if(visited.contains(i)) {
                return false;
            }
            if(!dfs(i, node)) {
                return false;
            }
        }
        return true;
    }
}
