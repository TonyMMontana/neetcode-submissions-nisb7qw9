class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < times.length; i++) {
            adj.computeIfAbsent(times[i][0], v -> new ArrayList<>())
            .add(new int[] {times[i][1], times[i][2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<Integer> visited = new HashSet<>();
        int t = 0;

        minHeap.add(new int[]{0, k});

        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int w1 = cur[0];
            int n1 = cur[1];
            if(visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            t = w1;

            if(adj.containsKey(n1)) {
                for(int[] next : adj.get(n1)) {
                    int n2 = next[0], w2 = next[1];
                    if(!visited.contains(n2)) {
                        minHeap.add(new int[] {w1 + w2, n2});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
