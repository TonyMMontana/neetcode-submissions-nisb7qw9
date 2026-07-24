class Solution {
    Map<Integer, List<Integer>> map = new HashMap();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i< prerequisites.length; i++){
            map.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }
        
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, list, visited)){
                return new int[0];
            }
        }
    
        int[] result= new int[numCourses];
        for(int i = 0; i< numCourses; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean dfs(int course, List<Integer> list, int[] visited){
        if(visited[course] == 1){
            return false;
        }
        if(visited[course] == 2){
            return true;
        }
        visited[course] = 1;

        for(Integer preq : map.getOrDefault(course, new ArrayList<>())){
            if(!dfs(preq, list, visited)){
                return false;
            }
        }
        visited[course] = 2;
        list.add(course);
        return true;
    }
}
