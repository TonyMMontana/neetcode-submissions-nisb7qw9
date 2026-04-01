class Solution {
    public int minCostConnectPoints(int[][] points) {
        //i need to try to connect each point with others -> n^2
        //since i dont have any connections yet i dont need adjency list
        //or i will try to create adj list <, list<int[]>> and then ittereate over it
        // i will store int[] {lenght, x, y} this will allow me to remove smalles element


        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int result = 0;

        heap.add(new int[]{0, points[0][0], points[0][1]});
        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            int seenLength = cur[0];
            int x = cur[1];
            int y = cur[2];
            if(visited.contains(new Pair<>(x, y))) {
                continue;
            }
            visited.add(new Pair<>(x, y));
            result += seenLength;

            for(int i = 0; i < points.length; i++) {
                if(!visited.contains(new Pair<>(points[i][0], points[i][1]))) {
                    int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                    heap.add(new int[] {distance, points[i][0], points[i][1] });
                }
            }
        }
        return result;
    }
}
