class Solution {
    public int minCostConnectPoints(int[][] points) {
        //i need to try to connect each point with others -> n^2
        //since i dont have any connections yet i dont need adjency list
        //or i will try to create adj list <, list<int[]>> and then ittereate over it
        // i will store int[] {lenght, x, y} this will allow me to remove smalles element


        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        boolean[] visited = new boolean[points.length];
        int result = 0;

        heap.add(new int[]{0, 0});

        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            int seenLength = cur[0];
            int point = cur[1];
            if(visited[point]) {
                continue;
            }
            
            visited[point] = true;
            result += seenLength;

            for(int i = 0; i < points.length; i++) {
                if(!visited[i]) {
                    int distance = Math.abs(points[point][0] - points[i][0]) + Math.abs(points[point][1] - points[i][1]);
                    heap.add(new int[] {distance, i});
                }
            }
        }
        return result;
    }
}
