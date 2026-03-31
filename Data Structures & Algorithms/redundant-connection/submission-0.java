class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();
    int startNode = -1;

    public int[] findRedundantConnection(int[][] edges) {
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        dfs(1, -1);

        for(int i = edges.length - 1; i>= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(visiting.contains(u) && visiting.contains(v)) {
                return new int[] {u,v};
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parrent) {
        if(visited.contains(node)) {
            startNode = node;
            return true;
        }

        visited.add(node);
        for(int i : map.getOrDefault(node, new ArrayList<>())) {
            if(i == parrent) {
                continue;
            }
            if(dfs(i, node)) {
                if(startNode != -1) visiting.add(node);
                if(node == startNode) {
                    startNode = -1;
                }
                return true;
            }
        }
        return false;
    }
}
