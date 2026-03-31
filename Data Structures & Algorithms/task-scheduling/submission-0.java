class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char task : tasks) {
            arr[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i : arr) {
            if(i != 0) {
                maxHeap.add(i);
            }
        }
        int res = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            if(!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                if(task > 1) {
                    queue.addLast(new int[]{task - 1, res + n});
                }
            }
            
            if (!queue.isEmpty() && queue.peekFirst()[1] == res){
                maxHeap.add(queue.pollFirst()[0]);
            }
            res++;
        }
        return res;
    }
}
