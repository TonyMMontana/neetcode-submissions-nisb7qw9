class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //i have directed graph with weights. i need to respect k stops and choose cheapes options within k.
        //to avoid cycle i need to have visited arr. 
        //for sure i will need priority queue in which i will put source.
        //then itterate over adj list and for each next node i need to increment stops and price values and put back to the heap
        //heap should be compared on price
        //do this until stops value <= k and then return queue.poll();

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] flight : flights) {
            map.computeIfAbsent(flight[0], i -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        heap.add(new int[]{src, 0, 0});
        int[][] best = new int[n][k  + 2]; 
        for(int i = 0; i < n; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }
        best[src][0] = 0;

        while(!heap.isEmpty()) {
            int[] flight = heap.poll();
            int city = flight[0];
            int stopsUsed = flight[1];
            int cost = flight[2];
            
            if(city == dst) {
                return cost;
            }

            if(stopsUsed == k + 1) continue;
            if(!map.containsKey(city)) continue;

            for(int[] i : map.get(city)) {
                int next = i[0];
                int price = i[1];
                int nextCost = price + cost;
                int nextStops = stopsUsed + 1;
                if(nextCost < best[next][nextStops]) {
                    best[next][nextStops] = nextCost;
                    heap.add(new int[]{next, nextStops, nextCost});
                }                
            }
            
        }

        return -1;      
    }
}
