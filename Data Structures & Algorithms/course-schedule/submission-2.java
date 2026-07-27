class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] preq : prerequisites) {
            map.computeIfAbsent(preq[0], k -> new ArrayList<>()).add(preq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if(!map.containsKey(course) || map.get(course).isEmpty()) {
            return true;
        }
        if(visited.contains(course)) {
            return false;
        }
        visited.add(course);

        for(Integer preq : map.getOrDefault(course, new ArrayList<>())) {
            if(!dfs(preq)) {
                return false;
            }
        }
        map.put(course, new ArrayList<>());
        return true;
    } 
}
