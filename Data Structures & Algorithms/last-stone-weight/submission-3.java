class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for(int i : stones){
            queue.add(i);
        }

        while(queue.size() != 1){
            int a = queue.poll();
            int b = queue.poll();
            int c = a - b;
            queue.add(c);
            
        }
        return queue.poll();
    }
}
