class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();
    List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int[] arr : prerequisites) {
            map.computeIfAbsent(arr[1], k -> new ArrayList<>());
            List<Integer> list = map.get(arr[1]);
            list.add(arr[0]);
            map.put(arr[1], list);
        }
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return new int[0];
        }
        if(output.size() != numCourses) return new int[0];
        Collections.reverse(output);
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int node) {
        if(visited.contains(node)) {
            return true;
        }
        if(visiting.contains(node)) {
            return false;
        }
        visiting.add(node);
        for(int crs : map.getOrDefault(node, new ArrayList<>())) {
           if(!dfs(crs)) return false;
        }
        visiting.remove(node);
        visited.add(node);
        output.add(node);
        return true;
    }
}
