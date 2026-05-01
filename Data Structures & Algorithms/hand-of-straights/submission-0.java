class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a - b);

        for(int i = 0; i < hand.length; i++) {
            int count = map.getOrDefault(hand[i], 0);
            if(count == 0) {
                heap.add(hand[i]);
            }
            map.put(hand[i], count + 1);
        }
        while(!heap.isEmpty()) {
            int min = heap.peek();

            if(map.get(min) == 0) {
                heap.poll();
                continue;
            }
            
            for(int i = 0; i < groupSize; i++) {
                int count = map.getOrDefault(min + i, 0);
                if(count == 0) {
                    return false;
                }
                map.put(min + i, count - 1);
               
            }
        }
        return true;
        
    }
}
