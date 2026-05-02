class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a - b);

        for(int num : hand) {
            int count = map.getOrDefault(num, 0);
            if(count == 0) {
                heap.add(num);
            }
            map.put(num, count + 1);
        }

        while(!heap.isEmpty()) {
            int cur = heap.peek();
            if(map.get(cur) == 0) {
                heap.poll();
                continue;
            }
            for(int i = 0; i < groupSize; i++) {
                int count = map.getOrDefault(cur + i, 0);
                if(count == 0) {
                    return false;
                }
                map.put(cur + i, count - 1);
            }
        }
        return true;
    }
}
