class Solution {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Set<Integer> visited = new HashSet<>();

        for(int[] arr : prerequisites) {
            List<Integer> list = adjMap.getOrDefault(arr[1], new ArrayList<>());
            list.add(arr[0]);
            adjMap.put(arr[1], list);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, visited)) {
                return false;
            }
        }
        return true;        
    }

    private boolean dfs(int key, Set<Integer> visited) {
        if(visited.contains(key)) {
            return false;
        }
        if(adjMap.get(key) == null || adjMap.get(key).isEmpty()){
            return true;
        }
        visited.add(key);
        for(int i : adjMap.get(key)) {
            if(!dfs(i, visited)) {
                return false;
            }
        }
        visited.remove(key);
        adjMap.put(key, new ArrayList<>());
        return true;
    }
}
